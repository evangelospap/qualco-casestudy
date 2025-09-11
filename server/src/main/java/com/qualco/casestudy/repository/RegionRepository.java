package com.qualco.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualco.casestudy.model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    
}


