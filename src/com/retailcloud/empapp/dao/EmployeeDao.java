package com.retailcloud.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.retailcloud.empapp.model.Employee;
import com.retailcloud.empapp.util.JDBCMySqlConnection;

public class EmployeeDao {

	ArrayList<Employee> emp = new ArrayList<Employee>();

	Scanner s = new Scanner(System.in);
	Connection conn = null;

	public boolean insertEmpoyee() {

		PreparedStatement stmt = null;
		conn = JDBCMySqlConnection.getConnection();
		boolean status = true;

		String QUERY1 = "insert into Employee(employeeName,address,designation,contactNumber,email,annualCtc,yearsOfExperience,bloodGroup) values(?,?,?,?,?,?,?,?)";

		try {
			System.out.print("Enter the employee name");
			String name = s.next();
			System.out.print("Enter the address ");
			String address = s.next();
			s.nextLine();
			System.out.print("Enter the designation");
			String designation = s.nextLine();
			System.out.println("Enter the contact number");
			long contactNumber = s.nextLong();
			System.out.println("Enter the email");
			String email = s.next();
			System.out.println("Enter the annual ctc in lakhs");
			Double annualCtc = s.nextDouble();
			System.out.println("Enter total year of experience");
			int yearsOfExperience = s.nextInt();
			System.out.println("Enter the blood group");
			String bloodGroup = s.next();
			stmt = conn.prepareStatement(QUERY1);
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setString(3, designation);
			stmt.setLong(4, contactNumber);
			stmt.setString(5, email);
			stmt.setDouble(6, annualCtc);
			stmt.setInt(7, yearsOfExperience);
			stmt.setString(8, bloodGroup);
			status = stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	public void viewEmpoyee() {

		conn = JDBCMySqlConnection.getConnection();
		Statement stmt2 = null;
		try {
			stmt2 = conn.createStatement();
			ResultSet rs = stmt2.executeQuery("SELECT * FROM Employee");

			while (rs.next()) {
				// Retrieve by column name
				System.out.print(rs.getString("Employeename"));
				System.out.print(" " + rs.getString("address"));
				System.out.print(" " + rs.getString("designation"));
				System.out.print(" " + rs.getLong("contactNumber"));
				System.out.print(" " + rs.getString("email"));
				System.out.print(" " + rs.getDouble("annualCtc"));
				System.out.print(" " + rs.getInt("yearsofExperience"));
				System.out.println(" " + rs.getString("bloodGroup"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt2.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void overPaidEmployees() {
		Statement stmt4 = null;
		conn = JDBCMySqlConnection.getConnection();
		try {
			stmt4 = conn.createStatement();
			ResultSet rs4 = stmt4.executeQuery(
					"select Employeename, (AnnualCtc/YearsofExperience) as 'result' from Employee group by result having result>1");

			while (rs4.next()) {
				// Retrieve by column name
				System.out.println(rs4.getString("Employeename"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt4.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void underPaidEmployees() {

		conn = JDBCMySqlConnection.getConnection();
		Statement stmt5 = null;
		try {
			stmt5 = conn.createStatement();
			ResultSet rs5 = stmt5.executeQuery(
					"select Employeename, (AnnualCtc/YearsofExperience) as 'result' from Employee group by result having result<1");

			while (rs5.next()) {
				// Retrieve by column name
				System.out.println(rs5.getString("Employeename"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt5.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void employeeGroupByBloodgroup() {
		conn = JDBCMySqlConnection.getConnection();

		Statement stmt11 = null;
		try {
			stmt11 = conn.createStatement();
			ResultSet rs21 = stmt11.executeQuery("SELECT * FROM Employee");

			while (rs21.next()) {
				Employee employee = new Employee();
				employee.setEmployeeName(rs21.getString("Employeename"));
				employee.setAddress(rs21.getString("address"));
				employee.setDesignation(rs21.getString("designation"));
				employee.setContactNumber(rs21.getLong("contactNumber"));
				employee.setEmail(rs21.getString("email"));
				employee.setAnnualCtc(rs21.getDouble("annualCtc"));
				employee.setYearsOfExperience(rs21.getInt("yearsofExperience"));
				employee.setBloodGroup(rs21.getString("bloodGroup"));
				emp.add(employee);

			}
			Map<Object, List<Employee>> EmpbyBloodgroup = new HashMap<>();

			EmpbyBloodgroup = emp.stream().collect(Collectors.groupingBy(Employee::getBloodGroup));
			// System.out.println(EmpbyBloodgroup);
			Set set = EmpbyBloodgroup.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				System.out.println("BloodGroup : " + entry.getKey());
				System.out.println(" " + entry.getValue());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt11.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int editEmployee() {
		int status = 0;
		PreparedStatement stmt1 = null;
		String QUERY2 = "update Employee Set EmployeeName =?,Address=?,Designation=?,ContactNumber=?,Email=?,AnnualCTC=?,YearsofExperience=?,BloodGroup=? where EmployeeId=?";
		conn = JDBCMySqlConnection.getConnection();
		System.out.println("Enter the employee id");
		int employeeId = s.nextInt();
		System.out.print("Enter the employee name");
		String employeeName = s.next();
		System.out.print("Enter the address ");
		String employeeAddress = s.next();
		s.nextLine();
		System.out.print("Enter the designation");
		String employeeDesignation = s.nextLine();
		// s.nextLine();
		System.out.println("Enter the contact number");
		long employeeContactNumber = s.nextLong();
		System.out.println("Enter the email");
		String employeeEmail = s.next();
		System.out.println("Enter the annual ctc in lakhs");
		Double employeeAnnualCtc = s.nextDouble();
		System.out.println("Enter total year of experience");
		int employeeYearsOfExperience = s.nextInt();
		System.out.println("Enter the blood group");
		String employeeBloodGroup = s.next();
		try {
			stmt1 = conn.prepareStatement(QUERY2);
			stmt1.setInt(9, employeeId);
			stmt1.setString(1, employeeName);
			stmt1.setString(2, employeeAddress);
			stmt1.setString(3, employeeDesignation);
			stmt1.setLong(4, employeeContactNumber);
			stmt1.setString(5, employeeEmail);
			stmt1.setDouble(6, employeeAnnualCtc);
			stmt1.setInt(7, employeeYearsOfExperience);
			stmt1.setString(8, employeeBloodGroup);
			status = stmt1.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt1.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;

	}

}
