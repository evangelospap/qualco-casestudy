package com.qualco.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qualco.casestudy.dto.LanguageDto;
import com.qualco.casestudy.repository.CountryLanguageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public List<LanguageDto> getLanguagesForCountry(Long countryId) {
        return countryLanguageRepository.findByCountry_Id(countryId).stream()
                .map(cl -> new LanguageDto(cl.getLanguage().getLanguage(), cl.getOfficial()))
                .toList();
    }
}