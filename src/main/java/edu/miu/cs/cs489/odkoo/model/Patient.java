package edu.miu.cs.cs489.odkoo.model;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String mailingAddress;
	private LocalDate dateOfBirth;


	public Patient(String firstName, String lastName, String phoneNumber, String email, String mailingAddress, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.mailingAddress = mailingAddress;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		if (dateOfBirth == null) return -1;
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "Patient{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				", mailingAddress='" + mailingAddress + '\'' +
				", dateOfBirth=" + dateOfBirth +
				'}';
	}
}
