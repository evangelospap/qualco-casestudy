package com.qualco.casestudy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.qualco.casestudy.dto.CountryDataDto;
import com.qualco.casestudy.model.Region;
import com.qualco.casestudy.repository.RegionRepository;
import com.qualco.casestudy.service.CountryDataService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country-data")
@RequiredArgsConstructor
public class CountryDataController {
	private final CountryDataService service;


    @GetMapping()
    public List<CountryDataDto> getCountryData(
            @RequestParam(required = false) Integer regionId,
            @RequestParam(required = false) Integer yearFrom,
            @RequestParam(required = false) Integer yearTo
    ) {
        return service.getCountryData(regionId, yearFrom, yearTo);
    }

}
