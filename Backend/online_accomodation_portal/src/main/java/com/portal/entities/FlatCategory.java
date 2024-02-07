package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="flat_category")
@Getter
@Setter
@NoArgsConstructor            
public class FlatCategory extends BaseEntity {
	
	@Column(nullable=false)
	private String category;
	
	@Column(length =50)
	private String description;

}
