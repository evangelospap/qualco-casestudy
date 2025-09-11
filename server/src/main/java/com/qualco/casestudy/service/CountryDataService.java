package com.qualco.casestudy.service;

import org.springframework.stereotype.Service;

import com.qualco.casestudy.dto.CountryDataDto;
import com.qualco.casestudy.repository.CountryStatRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryDataService {
    private final CountryStatRepository countryStatRepository;


    public List<CountryDataDto> getCountryData(Integer regionId, Integer yearFrom, Integer yearTo) {
        // Fetch all stats, filter by region and year
        throw new UnsupportedOperationException("Unimplemented method 'getCountryData'");

    }
}
