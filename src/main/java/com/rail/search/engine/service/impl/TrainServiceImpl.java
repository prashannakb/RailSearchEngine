package com.rail.search.engine.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rail.search.engine.entity.Train;
import com.rail.search.engine.entity.dto.TrainDTO;
import com.rail.search.engine.repository.TrainRepository;
import com.rail.search.engine.service.TrainService;
@Service
@Transactional
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Integer createTrain(TrainDTO traindto) {
		Train train=trainRepository.save(mapper.map(traindto,Train.class));
		
		
		return train.getId();
	}

	@Override
	public String updateTrainfare(Double fare, Integer trainId) throws Exception {
		// TODO Auto-generated method stub
		Train train=trainRepository.findById(trainId).orElseThrow(()->new Exception("Train not Found"));
		train.setFare(fare);
		trainRepository.save(train);
		return "Train Fare Was Updated \n Fare :: "+fare;
	}

}
