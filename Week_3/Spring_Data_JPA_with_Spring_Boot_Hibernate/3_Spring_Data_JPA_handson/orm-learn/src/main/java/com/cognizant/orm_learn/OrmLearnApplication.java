package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.AttemptService;
import com.cognizant.orm_learn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static EmployeeService employeeService;

	private static AttemptService attemptService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
//		employeeService = context.getBean(EmployeeService.class);
//		testGetAllPermanentEmployees();

//		attemptService = context.getBean(AttemptService.class);
//		testPrintAttempt(1,1);

		employeeService = context.getBean(EmployeeService.class);
//		testGetAverageSalary();

		testGetAllEmployeesNative();
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees: {}", employees);
		employees.forEach(e -> {
			LOGGER.debug("Employee: {}", e);
			LOGGER.debug("Department: {}", e.getDepartment());
			LOGGER.debug("Skills: {}", e.getSkillList());
		});
		LOGGER.info("End");
	}



	public static void testPrintAttempt(int userId, int attemptId) {
		Attempt a = attemptService.getAttempt(userId, attemptId);
		for (AttemptQuestion aq : a.getAttemptQuestions()) {
			System.out.println(aq.getQuestion().getQtText());
			for (AttemptOption ao : aq.getAttemptOptions()) {
				Options o = ao.getOption();
				System.out.printf(" %d) %-12s %.1f    %b\n", o.getOpId(), o.getOpText(), o.getOpScore(), ao.isAoSelected());
			}
		}
	}



	private static void testGetAverageSalary() {
		LOGGER.info("Start");
		double averageSalary = employeeService.getAverageSalary();
		LOGGER.debug("Average Salary: {}", averageSalary);
		LOGGER.info("End");
	}

	private static void testGetAverageSalaryByDepartment() {
		LOGGER.info("Start");
		int deptId = 1;
		double averageSalary = employeeService.getAverageSalary(deptId);
		LOGGER.debug("Average Salary for Department {}: {}", deptId, averageSalary);
		LOGGER.info("End");
	}


	private static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employeeList = employeeService.getAllEmployeesNative();
		for (Employee emp : employeeList) {
			LOGGER.debug("Employee: {}", emp);
		}
		LOGGER.info("End");
	}


}
