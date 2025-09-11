package com.qualco.casestudy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualco.casestudy.dto.RegionDto;
import com.qualco.casestudy.service.RegionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService service;

	@GetMapping()
    public List<RegionDto> getRegions() {
        return service.getAllRegions();
    }

}
