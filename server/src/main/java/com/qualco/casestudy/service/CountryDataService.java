package com.qualco.casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qualco.casestudy.model.CountryStat;
import com.qualco.casestudy.repository.CountryStatRepository;
import com.qualco.casestudy.specifications.CountryStatFilter;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CountryDataService {
    private final CountryStatRepository countryStatRepository;

    public Page<CountryStat> getCountryData(Long regionId, Integer yearFrom, Integer yearTo, Pageable pageable) {
        return countryStatRepository.findAll(
                CountryStatFilter.byRegionAndYear(regionId, yearFrom, yearTo),
                pageable
        );
    }
}
