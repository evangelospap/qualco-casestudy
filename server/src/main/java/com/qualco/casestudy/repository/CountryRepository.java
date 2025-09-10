package com.qualco.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualco.casestudy.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
