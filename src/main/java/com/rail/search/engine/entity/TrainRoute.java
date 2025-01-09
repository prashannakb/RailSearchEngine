package com.rail.search.engine.entity;

import com.rail.search.engine.entity.dto.TrainRoutekey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="train_route")
@IdClass(TrainRoutekey.class)
public class TrainRoute {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "route")
	private Route route;
	@Id
	@ManyToOne 
	@JoinColumn(name = "train")
	private Train train;

}
