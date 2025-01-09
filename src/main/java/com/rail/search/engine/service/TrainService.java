package com.rail.search.engine.service;

import com.rail.search.engine.entity.dto.TrainDTO;

public interface TrainService {
	
	
	
	public Integer createTrain( TrainDTO traindto );
	
	
	public String updateTrainfare( Double fare, Integer trainId) throws Exception;

}
