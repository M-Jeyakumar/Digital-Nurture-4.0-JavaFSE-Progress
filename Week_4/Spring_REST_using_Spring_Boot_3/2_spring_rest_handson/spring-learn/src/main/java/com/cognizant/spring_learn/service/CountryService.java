package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    public List<Country> getAllCountries() {
        return context.getBean("countryList", List.class);
    }

    public Country getCountry(String code) {
        List<Country> countryList = getAllCountries();
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public Country getDefaultCountry() {
        return context.getBean("country", Country.class);
    }
}
