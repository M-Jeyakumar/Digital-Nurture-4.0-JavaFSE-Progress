package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

//		testGetAllCountries();
		testAddCountry();

//		testCountryCrudOperations();

//		getCountryByCodeTest();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start");

		Country country = new Country();
		country.setCode("TC");
		country.setName("Test Country");

		countryService.addCountry(country);

		LOGGER.debug("Inserted Country: {}", country);
		LOGGER.info("End");
	}

	private static void testCountryCrudOperations() throws CountryNotFoundException {
		LOGGER.info("START");

		// Add
		Country newCountry = new Country();
		newCountry.setCode("US");
		newCountry.setName("United States");
		countryService.addCountry(newCountry);

		// Find by Code
		Country country = countryService.findCountryByCode("US");
		LOGGER.debug("Country: {}", country);

		// Update
		country.setName("USA");
		countryService.updateCountry(country);

		// Find Partial
		List<Country> countries = countryService.findByPartialName("A");
		countries.forEach(c -> LOGGER.debug("Partial match: {}", c));

		// Delete
		countryService.deleteCountry("US");

		LOGGER.info("END");
	}

	private static void getCountryByCodeTest() {
		LOGGER.info("Start");
		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}
		LOGGER.info("End");
	}
}
