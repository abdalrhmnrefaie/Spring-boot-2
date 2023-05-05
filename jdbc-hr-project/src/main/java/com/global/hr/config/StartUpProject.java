package com.global.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;

@Component
public class StartUpProject implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmployeeReps employeeReps;

	@Override
	public void run(String... args) throws Exception {

		jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
		jdbcTemplate.execute("CREATE TABLE employee(id SERIAL,name VARCHAR(255),salary NUMERIC(15,2))");

		if (employeeReps.count() == 0) {
			employeeReps.insert(new Employee(20L, "abdalrhmn", 101010.0));
			employeeReps.insert(new Employee(30L, "Mohamed", 202020.0));
			employeeReps.insert(new Employee(40L, "Hossam", 303030.0));
		}

	}

}
