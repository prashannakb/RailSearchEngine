package com.rail.search.engine.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rail.search.engine.entity.dto.RouteDTO;
import com.rail.search.engine.entity.dto.TrainDTO;
import com.rail.search.engine.exception.SearchException;
import com.rail.search.engine.service.RouteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rail")
//@Validated
public class RouteResource {
	
	@Autowired
	private RouteService routeService;
	
	@PostMapping("/routes")
	public ResponseEntity<Integer> createRoute(@Valid @RequestBody  RouteDTO route){
		Integer resp=routeService.createRoute(route);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/routes/{routeId}")//@Pattern(regexp="^{0-3}$") 
	public ResponseEntity<?> getRoute(@PathVariable("routeId")Integer  routeId ) throws Exception{
		RouteDTO route=null;
//		try {
			route=routeService.getRoute(routeId);
//		}
//		catch(Exception ex) {
//			return ResponseEntity.badRequest().body(ex.getMessage());
//		}
		return ResponseEntity.ok(route);
	}
	
	@GetMapping("/routes/trains")
	public ResponseEntity<?> getRouteBasedonLoc(@RequestParam("source")String source,@RequestParam ("destination") String destination) throws SearchException{
		List<RouteDTO> resp=null;
//		try {
			resp=routeService.getRouteBasedonLoc(source, destination);
			
//		}catch(Exception ex) {
//			return  ResponseEntity.badRequest().body(ex.getMessage());
//		}
		return new ResponseEntity<>(resp,new HttpHeaders(),HttpStatus.FOUND);
	}
	
	@PutMapping("/route/{routeid}")
	public ResponseEntity<?> updateRoute(@PathVariable("routeid") Integer id,@RequestParam("source")String source,@RequestParam ("destination") String destination) throws SearchException{
		RouteDTO resp=null;
//		try {
			resp=routeService.updateRoute(id, source, destination);
			
//		}catch(Exception ex) {
//			return  ResponseEntity.badRequest().body(ex.getMessage());
//		}
		return new ResponseEntity<>(resp,new HttpHeaders(),HttpStatus.OK);
		
	}
	@DeleteMapping("/route/{routeId}/{trainId}")
	public ResponseEntity<String> deleteRouteTrain(@PathVariable("routeId") Integer routeId,@PathVariable("trainId") Integer trainId) throws SearchException{
		String resp=null;
//		try {
			resp=routeService.deleteRouteTrain(routeId, trainId);
			
//		}catch(Exception ex) {
//			return  ResponseEntity.badRequest().body(ex.getMessage());
//		}
		return new ResponseEntity<>(resp,new HttpHeaders(),HttpStatus.ACCEPTED);
		
	}
	@PutMapping("/routes/{routeId}")
	public ResponseEntity<String> updateTrain(@Valid @RequestBody TrainDTO train,@PathVariable("routeId") Integer routeId) throws SearchException{
		String resp=null;

			resp=routeService.updateTrain(train, routeId);
			
//		}catch(Exception ex) {
//			return  ResponseEntity.badRequest().body(ex.getMessage());
//		}
		return new ResponseEntity<>(resp,new HttpHeaders(),HttpStatus.ACCEPTED);
	}
	
	
	
	
	

}
