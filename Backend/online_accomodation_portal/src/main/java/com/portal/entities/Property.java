package com.portal.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "property_details")
public class Property extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@OneToOne
	@JoinColumn(name = "flat_category_id")
	private FlatCategory category;

	@Column(length = 150)
	private String instructions;

	@Column(name = "status")
	private Boolean isAvailable;

	private int deposit;

	private int rent;
	@Column(length = 75)
	private String society;
	@Column(length = 50)
	private String landmark;
	@Column(length = 75)
	private String area;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	public Property() {

	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public FlatCategory getCategory() {
		return category;
	}

	public void setCategory(FlatCategory category) {
		this.category = category;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
