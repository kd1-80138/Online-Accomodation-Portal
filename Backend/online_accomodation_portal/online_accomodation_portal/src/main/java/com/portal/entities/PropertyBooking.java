package com.portal.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property_booking")
@Setter
@Getter

public class PropertyBooking extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "flat_Category_id")
	private FlatCategory flatCategoryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;

	@OneToOne
	@JoinColumn(name = "property_id")
	private Property propertyId;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "booking_date_time")
	private LocalDateTime bookingDateTime;

	public PropertyBooking() {

	}

}
