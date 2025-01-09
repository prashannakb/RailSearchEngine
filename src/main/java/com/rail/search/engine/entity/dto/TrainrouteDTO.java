package com.rail.search.engine.entity.dto;

import com.rail.search.engine.entity.Route;
import com.rail.search.engine.entity.Train;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TrainrouteDTO {
	
	private Route route;
	private Train train;

}
