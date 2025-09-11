package com.qualco.casestudy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.qualco.casestudy.dto.CountryDataDto;
import com.qualco.casestudy.service.CountryDataService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country-data")
@RequiredArgsConstructor
public class CountryDataController {
	private final CountryDataService service;

    @GetMapping
    public Page<CountryDataDto> getCountryData(
        @RequestParam(required = false) Integer regionId,
        @RequestParam(required = false) Integer yearFrom,
        @RequestParam(required = false) Integer yearTo,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "1000") int size
    ) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "year"));
    return service.getCountryData(regionId, yearFrom, yearTo, pageable)
        .map(stat -> new CountryDataDto(
                stat.getContinent(),
                stat.getRegion(),
                stat.getCountry(),
                stat.getYear(),
                stat.getPopulation(),
                stat.getGdp()
        ));
    }

}
