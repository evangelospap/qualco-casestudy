package com.qualco.casestudy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualco.casestudy.dto.CountryDto;
import com.qualco.casestudy.dto.LanguageDto;
import com.qualco.casestudy.service.CountryLanguageService;
import com.qualco.casestudy.service.CountryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService service;
    private final CountryLanguageService countryLanguageService;

    @GetMapping
    public List<CountryDto> getCountries() {
        return service.getAllCountries();
    }

    @GetMapping("/{id}/languages")
    public List<LanguageDto> getLanguages(@PathVariable Long id) {
        return countryLanguageService.getLanguagesForCountry(id);
    }
}
