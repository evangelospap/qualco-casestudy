package com.qualco.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qualco.casestudy.dto.RegionDto;
import com.qualco.casestudy.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepo;

    public List<RegionDto> getAllRegions() {
      return regionRepo.findAll()
        .stream()
        .map(r -> new RegionDto(r.getId(), r.getName(), r.getContinent().getName()))
        .toList();
    }
    
}

