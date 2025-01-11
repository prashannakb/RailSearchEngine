package com.rail.search.engine.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rail.search.engine.entity.Route;
import com.rail.search.engine.entity.Train;
import com.rail.search.engine.entity.dto.Appconstant;
import com.rail.search.engine.entity.dto.RouteDTO;
import com.rail.search.engine.entity.dto.TrainDTO;
import com.rail.search.engine.exception.SearchException;
import com.rail.search.engine.repository.RouteRepository;
import com.rail.search.engine.service.RouteService;

@Service
@Transactional
@PropertySource("classpath:validation.properties")
public class RouteServiceImpl implements RouteService{
//	Logger log=Logger.(RouteServiceImpl.class);
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Environment env;
	@Override
	public Integer createRoute(RouteDTO route) {
		// TODO Auto-generated method stub
		Route route1=null;
		System.out.println("Route");
		System.out.println(route);
		if(null==route.getTrains()) {
			Route route3=mapper.map(route, Route.class);
			Route route2=routeRepository.save(route3);
			System.out.println(route2);
			route1=route2;
			
		}
		
		System.out.println("Route :: "+route1);
		return route1.getId();
	}

	@Override
	public RouteDTO getRoute(Integer routeId) throws SearchException {
		System.out.println("RouteId :: "+routeId);
		Route route=routeRepository.findById(routeId).orElseThrow(()->new SearchException(env.getProperty(Appconstant.ROUTE_NOT_FOUND.toString())));
		System.out.println("route :: "+route);
		return mapper.map(route, RouteDTO.class);
	}

	@Override
	public List<RouteDTO> getRouteBasedonLoc(String source, String destination)throws SearchException {
		List<Route> routes=routeRepository.findBySourceAndDestination(source,destination);
		System.out.println(env.getProperty(Appconstant.DIRECT_ROUTE_MISSING.toString()));
		if(routes.size()==0) {
			throw new SearchException(env.getProperty(Appconstant.DIRECT_ROUTE_MISSING.toString()));
		}
		List<RouteDTO> routesDto=new ArrayList<RouteDTO>();
		for(Route route:routes) {
			RouteDTO routeDto=mapper.map(route, RouteDTO.class);
			routesDto.add(routeDto);
		}
		return routesDto;
	}

	@Override
	public RouteDTO updateRoute(Integer id, String source, String destination) throws SearchException{
		// TODO Auto-generated method stub
		Route route=routeRepository.findById(id).orElseThrow(()->new SearchException(env.getProperty(Appconstant.ROUTE_NOT_FOUND.toString())));
		route.setDestination(destination);
		route.setSource(source);
		routeRepository.save(route);
		
		return mapper.map(route, RouteDTO.class);
	}

	@Override
	public String deleteRouteTrain(Integer routeId, Integer trainId) throws SearchException{
		Route route=routeRepository.findById(routeId).orElseThrow(()->new SearchException(env.getProperty(Appconstant.ROUTE_NOT_FOUND.toString())));
		Boolean flag=false;
		Train id=null;
		for(Train train:route.getTrains()) {
			if(train.getId()==trainId) {
				flag=true;
				id=train;
			}
		}
		if(flag) {
			route.getTrains().remove(id);
		}
		else {
			throw new SearchException(env.getProperty(Appconstant.TRAIN_ROUTE.toString()));
		}
		routeRepository.save(route);
		// TODO Auto-generated method stub
		return "Train Cancelled ";
	}

	@Override
	public String updateTrain(TrainDTO train, Integer routeId)throws SearchException {
		// TODO Auto-generated method stub
		Route route=routeRepository.findById(routeId).orElseThrow(()->new SearchException(env.getProperty(Appconstant.ROUTE_NOT_FOUND.toString())));
		Boolean flag=false;
		Train id=mapper.map(train, Train.class);
		route.getTrains().add(id);
		
		routeRepository.save(route);
		return "New Train is Added in the route";
	}

}
