package com.rail.search.engine.entity.dto;

import java.util.List;

import com.rail.search.engine.entity.Train;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RouteDTO {
//	@Pattern(regexp="^{0-3}$")
	private int id;
	@NotEmpty
	@NotNull
	private String source;
	@NotEmpty
	@NotNull
	private String destination;
	
	private List<Train> trains;

}
