package com.rail.search.engine.service;

import java.util.List;

import com.rail.search.engine.entity.dto.RouteDTO;
import com.rail.search.engine.entity.dto.TrainDTO;
import com.rail.search.engine.exception.SearchException;

public interface RouteService {
	
	
	public Integer createRoute(  RouteDTO route);
	public RouteDTO getRoute(Integer routeId )throws Exception;
	public List<RouteDTO>getRouteBasedonLoc(String source, String destination)throws SearchException;
	public RouteDTO updateRoute(Integer id,String source, String destination)throws SearchException;
	public String deleteRouteTrain(Integer routeId,Integer trainId)throws SearchException;
	public String updateTrain( TrainDTO train, Integer routeId)throws SearchException;

}
