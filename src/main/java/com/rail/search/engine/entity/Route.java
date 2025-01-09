package com.rail.search.engine.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name="route")
@Entity
public class Route {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "source", nullable = false)
	private String source;
	@Column(name = "destination", nullable = false)
	private String destination;
	@ManyToMany 
	@JoinTable( name = "train_route",
	joinColumns = @JoinColumn(name = "route"),
	inverseJoinColumns = @JoinColumn(name = "train") )
	private List<Train> trains;

}
