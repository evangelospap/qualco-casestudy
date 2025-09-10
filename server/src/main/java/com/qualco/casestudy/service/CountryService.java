package com.qualco.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qualco.casestudy.dto.CountryDto;
import com.qualco.casestudy.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(c -> new CountryDto(
                        c.getId(),
                        c.getName(),
                        c.getArea(),
                        c.getCountryCode2()
                ))
                .toList();
    }
}
