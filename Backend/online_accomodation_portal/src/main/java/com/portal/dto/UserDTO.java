package com.portal.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/dto/UserDTO.java
=======
import com.portal.entities.City;
import com.portal.entities.Status;
import com.portal.entities.User;
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/dto/UserDTO.java

import com.portal.entities.Gender;
import com.portal.entities.Status;
import com.portal.entities.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private long mobileNo;

	@Email
	private String emaiId;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;

<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/dto/UserDTO.java
	private String address;

	private UserRole role;

	private Gender gender;
=======
	@JsonProperty(access = Access.WRITE_ONLY)
	private City cityId;

	private User userType;
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/dto/UserDTO.java

	private Status status;
}
