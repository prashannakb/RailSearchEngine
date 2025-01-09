package com.rail.search.engine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name="train")
@Entity
public class Train {
	
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="arrival")
	private String arrival;
	
	@Column(name="departure")
	private String departure;
	
	@Column(name="train_name")
	private String name;
	
	@Column(name="fare")
	private Double fare;

}
