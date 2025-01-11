package com.rail.search.engine.service;

import com.rail.search.engine.entity.dto.TrainDTO;
import com.rail.search.engine.exception.SearchException;

public interface TrainService {
	
	
	
	public Integer createTrain( TrainDTO traindto );
	
	
	public String updateTrainfare( Double fare, Integer trainId) throws SearchException;

}
