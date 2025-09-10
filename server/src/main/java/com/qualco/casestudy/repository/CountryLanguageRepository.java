package com.qualco.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualco.casestudy.model.CountryLanguage;
import com.qualco.casestudy.model.CountryLanguageId;


public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    List<CountryLanguage> findByCountry_Id(Long countryId);
}
