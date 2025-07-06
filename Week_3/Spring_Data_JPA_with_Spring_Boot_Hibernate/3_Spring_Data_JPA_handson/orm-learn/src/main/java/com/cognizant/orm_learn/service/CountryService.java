package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

//    @Transactional(readOnly = true)
//    public Country findCountryByCode(String code) {
//        return countryRepository.findById(code).orElse(null);
//    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> findByPartialName(String name) {
        return countryRepository.findByNameContaining(name);
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }
        return result.get();
    }

    @Transactional
    public List<Country> findCountriesByNameContaining(String keyword) {
        return countryRepository.findByNameContaining(keyword);
    }

    @Transactional
    public List<Country> findCountriesByNameContainingSorted(String keyword) {
        return countryRepository.findByNameContainingOrderByNameAsc(keyword);
    }

    @Transactional
    public List<Country> findCountriesStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }


}
