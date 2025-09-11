package com.qualco.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qualco.casestudy.model.Region;
import com.qualco.casestudy.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepo;

    public List<Region> getAllRegions() {
      return regionRepo.findAll();
    }
    
}

