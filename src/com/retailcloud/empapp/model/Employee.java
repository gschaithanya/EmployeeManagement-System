package com.retailcloud.empapp.model;

public class Employee {

	
		// TODO Auto-generated method stub
		private int employeeId;
		private String employeeName;
		private String address;
		private String designation;
		private long contactNumber;
		private String email;
		private double annualCtc;
		private int yearsOfExperience;
		private String bloodGroup;
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(int employeeId, String employeeName, String address, String designation, long contactNumber,
				String email, double annualCtc, int yearsOfExperience, String bloodGroup) {
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.address = address;
			this.designation = designation;
			this.contactNumber = contactNumber;
			this.email = email;
			this.annualCtc = annualCtc;
			this.yearsOfExperience = yearsOfExperience;
			this.bloodGroup = bloodGroup;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public long getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(long contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public double getAnnualCtc() {
			return annualCtc;
		}
		public void setAnnualCtc(double annualCtc) {
			this.annualCtc = annualCtc;
		}
		public int getYearsOfExperience() {
			return yearsOfExperience;
		}
		public void setYearsOfExperience(int yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
		}
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		@Override
		public String toString() {
			return "Employee [employeeName=" + employeeName + ", address=" + address
					+ ", designation=" + designation + ", contactNumber=" + contactNumber + ", email=" + email
					+ ", annualCtc=" + annualCtc + ", yearsOfExperience=" + yearsOfExperience + ", bloodGroup=" + bloodGroup
					+ "]";
		}
	}
		
		
		


	


