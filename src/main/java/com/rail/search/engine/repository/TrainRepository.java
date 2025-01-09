package com.rail.search.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rail.search.engine.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer>{

}
