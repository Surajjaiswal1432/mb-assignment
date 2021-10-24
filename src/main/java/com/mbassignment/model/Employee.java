package com.mbassignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;

	@Pattern(regexp = "^[A-Za-z ]*$", message = "Invalid First Name")
	@NotBlank(message = "First Name not be empty")
	private String firstname;

	@Pattern(regexp = "^[A-Za-z ]*$", message = "Invalid Last Name")
	@NotBlank(message = "Last name can  not be empty")
	private String lastname;

	@Pattern(regexp = "(^$|[0-9]{10})", message = "invalid Mobile number")
	@Size(max = 10, min = 10, message = "Mobile number should be of 10 digits")
	@NotEmpty(message = "Mobile Number is required")
	private String mobile;

	@NotEmpty(message = "Date can not be empty")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String dob;

	@NotBlank(message = "City can not be empty")
	private String city;

	@NotBlank(message = "Address can not be empty")
	private String address;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", mobile=" + mobile
				+ ", dob=" + dob + ", city=" + city + ", address=" + address + "]";
	}

}
