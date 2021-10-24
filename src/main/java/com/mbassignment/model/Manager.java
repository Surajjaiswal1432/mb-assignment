package com.mbassignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.mbassignment.service.ManagerService;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Pattern(regexp = "^[A-Za-z ]*$", message = "Invalid First Name")
	@NotBlank(message = "First Name not be empty")
	private String firstname;

	@Pattern(regexp = "^[A-Za-z ]*$", message = "Invalid Last Name")
	@NotBlank(message = "Last name can  not be empty")
	private String lastname;

	@Column(unique = true)
	@NotBlank(message = "Email can not be empty")
	@Email(message = "Please enter a valid e-mail address")
	private String email;

	@NotBlank(message = "Password can not be empty")
	private String password;

	@NotBlank(message = "Address can not be empty")
	private String address;

	@NotEmpty(message = "Date can not be empty")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String dob;

	private String role;

	@NotBlank(message = "Company can not be empty")
	private String company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", dob=" + dob + ", company=" + company + "]";
	}

}
