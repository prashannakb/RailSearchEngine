package com.rail.search.engine.entity.dto;

import java.io.Serializable;

public enum Appconstant{
	
	
	DIRECT_ROUTE_MISSING("direct.route.missing"),
	ROUTE_NOT_FOUND("route.not.found"),
	TRAIN_NOT_FOUND("train.not.found"),
	TRAIN_ROUTE("train.route");
	
	private String type;

	private Appconstant(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
	return this.type;
	}
		
		

}
