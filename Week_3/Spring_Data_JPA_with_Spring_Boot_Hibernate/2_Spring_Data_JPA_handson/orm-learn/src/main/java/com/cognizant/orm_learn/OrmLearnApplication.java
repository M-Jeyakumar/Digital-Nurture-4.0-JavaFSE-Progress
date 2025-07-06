package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import java.sql.Date;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static StockRepository stockRepository;

	private static EmployeeService employeeService;

	private static DepartmentService departmentService;

	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

//		countryService = context.getBean(CountryService.class);
//		testGetAllCountries();
//		testAddCountry();
//		testCountryCrudOperations();
//		getCountryByCodeTest();
//		testFindCountriesByPartialName();
//		testFindCountriesByPartialNameSorted();
//		testFindCountriesByStartingAlphabet();

//		stockRepository = context.getBean(StockRepository.class);
//		testStockQueries();

		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);

//		 testAddEmployee();
//		 testUpdateEmployee();
//		 testGetEmployee();

//		testGetDepartment();

		skillService = context.getBean(SkillService.class);

		// testGetEmployee(); // Comment this
		testAddSkillToEmployee(); // Enable this
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

	private static void testFindCountriesByPartialName() {
		LOGGER.info("Start - Partial Match");
		List<Country> countries = countryService.findCountriesByNameContaining("ou");
		countries.forEach(c -> LOGGER.debug("Country: {}", c));
		LOGGER.info("End");
	}

	private static void testFindCountriesByPartialNameSorted() {
		LOGGER.info("Start - Sorted Partial Match");
		List<Country> countries = countryService.findCountriesByNameContainingSorted("ou");
		countries.forEach(c -> LOGGER.debug("Country: {}", c));
		LOGGER.info("End");
	}

	private static void testFindCountriesByStartingAlphabet() {
		LOGGER.info("Start - Starts With 'Z'");
		List<Country> countries = countryService.findCountriesStartingWith("Z");
		countries.forEach(c -> LOGGER.debug("Country: {}", c));
		LOGGER.info("End");
	}



	private static void testStockQueries() {
		LOGGER.info("Start");

		List<Stock> fbStocks = stockRepository.findByCodeAndDateBetween("FB",
				LocalDate.of(2019, 9, 1),
				LocalDate.of(2019, 9, 30));
		fbStocks.forEach(stock -> LOGGER.debug("FB Sep 2019: {}", stock));

		List<Stock> googleStocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
		googleStocks.forEach(stock -> LOGGER.debug("GOOGL > 1250: {}", stock));

		List<Stock> topVolume = stockRepository.findTop3ByOrderByVolumeDesc();
		topVolume.forEach(stock -> LOGGER.debug("Top Volume: {}", stock));

		List<Stock> lowestNetflix = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
		lowestNetflix.forEach(stock -> LOGGER.debug("Lowest NFLX: {}", stock));

		LOGGER.info("End");
	}



	private static void testAddEmployee() {
		LOGGER.info("Start");

		Employee employee = new Employee();
		employee.setName("Ravi Kumar");
		employee.setSalary(25000);
		employee.setPermanent(true);
		employee.setDateOfBirth(Date.valueOf("1999-05-10"));

		Department department = departmentService.get(1);
		employee.setDepartment(department);

		employeeService.save(employee);

		LOGGER.debug("Employee: {}", employee);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");

		Employee employee = employeeService.get(1);
		Department newDept = departmentService.get(2);

		employee.setDepartment(newDept);
		employeeService.save(employee);

		LOGGER.debug("Updated Employee: {}", employee);
		LOGGER.info("End");
	}


	private static void testGetDepartment() {
		LOGGER.info("Start");

		Department department = departmentService.get(1);
		LOGGER.debug("Department: {}", department);
		LOGGER.debug("Employees: {}", department.getEmployeeList());

		LOGGER.info("End");
	}


	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee: {}", employee);
		LOGGER.debug("Department: {}", employee.getDepartment());
		LOGGER.debug("Skills: {}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");

		Employee employee = employeeService.get(2);
		Skill skill = skillService.get(1);

		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);

		employee.setSkillList(skillList);
		employeeService.save(employee);

		LOGGER.debug("Updated Employee: {}", employee);
		LOGGER.info("End");
	}


}
