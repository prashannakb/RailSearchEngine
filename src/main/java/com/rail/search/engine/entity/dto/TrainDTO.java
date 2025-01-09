package com.rail.search.engine.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDTO {

private int id;
	
	@NotEmpty
	@NotNull
	private String arrival;
	
	@NotEmpty
	@NotNull
	private String departure;
	
	@NotEmpty
	@NotNull
	private String name;
	
	
	@NotNull
	@Positive
	private Double fare;
}
