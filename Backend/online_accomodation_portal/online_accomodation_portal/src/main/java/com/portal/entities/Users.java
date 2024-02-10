package com.portal.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropertyBooking> bookingList;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropertyReview> reviewList;

	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private User userType;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public Users() {

	}

	// add property to list
	public void addProperty(Property p) {
		propertyList.add(p);// user --> propertyList
		p.setUser(this);// propertyList --> user
	}

	public void removeProperty(Property p) {
		propertyList.remove(p);
		p.setUser(null);
	}

	// add review to list
	public void addPropertyReview(PropertyReview r) {
		reviewList.add(r);// user --> reviewList
		r.setUser(this);// reviewList --> user
	}

	public void removePropertyReview(PropertyReview r) {
		reviewList.remove(r);
		r.setUser(null);
	}

	public void addPropertyBooking(PropertyBooking b) {
		bookingList.add(b);// user --> bookingList
		b.setUser(this);// bookingList --> user
	}

	public void removePropertyBooking(PropertyBooking b) {
		bookingList.remove(b);
		b.setUser(null);
	}

}
