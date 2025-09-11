package com.qualco.casestudy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.qualco.casestudy.dto.CountryDataDto;
import com.qualco.casestudy.model.CountryStat;
import com.qualco.casestudy.service.CountryDataService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<CountryDataDto> getCountryData(
            @RequestParam(required = false) Long regionId,
            @RequestParam(required = false) Integer yearFrom,
            @RequestParam(required = false) Integer yearTo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size ) {
        Page<CountryStat> statsPage = service.getCountryData(regionId, yearFrom, yearTo, PageRequest.of(page, size));

        return statsPage.map(stat -> new CountryDataDto(
                stat.getCountry().getRegion().getContinent().getName(),
                stat.getCountry().getRegion().getName(),
                stat.getCountry().getName(),
                stat.getYear(),
                stat.getPopulation(),
                stat.getGdp()
        ));
    }

}
