package com.rail.search.engine.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rail.search.engine.entity.dto.TrainDTO;
import com.rail.search.engine.service.TrainService;

import jakarta.validation.Valid;
@Validated
@RestController
@RequestMapping("/rail")
public class TrainResource {
	
	@Autowired
	private TrainService trainService;
	@PostMapping("/train")
	public ResponseEntity<Integer> createTrain(@Valid @RequestBody TrainDTO train ){
		Integer resp=trainService.createTrain(train);
		return new ResponseEntity<Integer>(resp,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/train/{trainId}")
	public ResponseEntity<String> updateTrainfare(@RequestParam("fare") Double fare,@PathVariable("trainId") Integer trainId){
		String resp=null;
		try {
			resp=trainService.updateTrainfare(fare, trainId);	
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return new ResponseEntity<>(resp,new HttpHeaders(),HttpStatus.OK);
	}

}
