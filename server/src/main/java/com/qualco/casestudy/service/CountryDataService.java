package com.qualco.casestudy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qualco.casestudy.dto.CountryDataProjection;
import com.qualco.casestudy.model.CountryStat;
import com.qualco.casestudy.repository.CountryStatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryDataService {
    private final CountryStatRepository countryStatRepository;

    public List<CountryStat> getCountryData() {
        return countryStatRepository.findAll();
    }

    public Page<CountryDataProjection> getCountryData(Integer regionId, Integer yearFrom, Integer yearTo, Pageable pageable) {
        return countryStatRepository.findCountryDataPaginated(regionId, yearFrom, yearTo, pageable);
    }
}
