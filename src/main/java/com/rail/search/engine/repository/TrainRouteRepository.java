package com.rail.search.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rail.search.engine.entity.TrainRoute;
import com.rail.search.engine.entity.dto.TrainRoutekey;

@Repository
public interface TrainRouteRepository extends JpaRepository<TrainRoute, TrainRoutekey>{

}
