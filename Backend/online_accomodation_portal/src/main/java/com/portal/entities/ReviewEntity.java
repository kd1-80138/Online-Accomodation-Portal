package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Property_Reviews")
@NoArgsConstructor
@Getter
@Setter
public class ReviewEntity extends BaseEntity {
	
	@JoinColumn(name="property_id")
	private Property property;
	
	@Column
	private float ratting;
	
	@Column(length = 250)
	private String comment;
	
	@JoinColumn(name="user_id")
	private Users user;
}
