package com.portal.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {

	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(name = "mobile_no", nullable = false)
	private long mobileNo;

	@Column(name = "email_id", unique = true, nullable = false)
	private String email;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Property> propertyList;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropertyBooking> bookingList;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropertyReview> reviewList;
	
		@ManyToOne
		private City city; 
		
		
	
	
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private User userType;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public Users() {
		this.bookingList= new ArrayList<PropertyBooking>();
		this.reviewList= new ArrayList<PropertyReview>();
		this.propertyList = new ArrayList<Property>();
		

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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmaiId(String emaiId) {
		this.email = emaiId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public User getUserType() {
		return userType;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserType(User userType) {
		this.userType = userType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
