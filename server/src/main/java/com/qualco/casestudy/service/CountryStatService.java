package com.qualco.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qualco.casestudy.dto.CountryStatDto;
import com.qualco.casestudy.dto.CountryTopStatProjection;
import com.qualco.casestudy.repository.CountryStatRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CountryStatService {
    private final CountryStatRepository countryStatRepository;

    public List<CountryStatDto> getCountryStats() {
        throw new UnsupportedOperationException("Unimplemented method 'getCountryStats'");
    }

    public List<CountryTopStatProjection> getCountriesWithTopGdpPerCapitaStats() {
        return countryStatRepository.findCountriesWithTopGdpPerCapitaStats();
    }
    
}
