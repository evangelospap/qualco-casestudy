package com.qualco.casestudy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualco.casestudy.dto.CountryDto;
import com.qualco.casestudy.dto.CountryStatDto;
import com.qualco.casestudy.dto.LanguageDto;
import com.qualco.casestudy.service.CountryLanguageService;
import com.qualco.casestudy.service.CountryService;
import com.qualco.casestudy.service.CountryStatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService service;
    private final CountryLanguageService countryLanguageService;
    private final CountryStatService countryStatService;

    @GetMapping
    public List<CountryDto> getCountries() {
        return service.getAllCountries();
    }

    @GetMapping("/{id}/languages")
    public List<LanguageDto> getLanguages(@PathVariable Integer id) {
        return countryLanguageService.getLanguagesForCountry(id);
    }

    @GetMapping("stats")
    public List<CountryStatDto> getCountryStats() {
        return countryStatService.getCountriesWithTopGdpPerCapitaStats()
            .stream()
            .map(projection -> new CountryStatDto(
                projection.getCountryName(),
                projection.getCountryCode3(),
                projection.getYear(),
                projection.getPopulation(),
                projection.getGdp()
            ))
            .toList();
    }

}
