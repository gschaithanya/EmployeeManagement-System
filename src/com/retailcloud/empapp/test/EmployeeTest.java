package com.retailcloud.empapp.test;
/*
 * Press 1  to insert a new Employee
 * Press 2 to View the employee details of the organization.
 * Press 3 to view the list of employees Categorized based on the Blood group
 * Press 4 to view employees who all are overpaid.
 * Press 5 to view employees who all are underpaid.
 * Press 6 to update the employess detils based on the employee id.
 * 
 * 
 */


import java.util.Scanner;

import com.retailcloud.empapp.dao.EmployeeDao;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		EmployeeDao employeedao = new EmployeeDao();
		System.out.println("Welcome to Employee Tracker");

		System.out.println(
				"Press  \n (1) to add new employee \n (2) View employee details  \n (3) View employee details based on bloodgroup\n (4) View employee who are over paid\n (5) view employee who all are underpaid \n (6) Edit Employee Details");
		int i = s.nextInt();

		switch (i) {
		case 1:
			boolean status = true;

			status = employeedao.insertEmpoyee();

			if (status == false) {
				System.out.println("Sucessfully inserted");
			}
			if (status == true) {
				System.out.println("Failed to insert");
			}
			break;
		case 2:
			employeedao.viewEmpoyee();
			break;

		case 3:
			
			employeedao.employeeGroupByBloodgroup();
			break;

		case 4:
			System.out.println("Employees who all are overpaid");

			employeedao.overPaidEmployees();

			break;

		case 5:
			

			employeedao.underPaidEmployees();
			

			break;
		case 6:
			int result=0;
			result=employeedao.editEmployee();
			if(result==1) {
				System.out.println("Sucessfully Updated");
				
			}
			else {
				System.out.println("Failed to update please check after sometime");
			}

		}

	}

}
