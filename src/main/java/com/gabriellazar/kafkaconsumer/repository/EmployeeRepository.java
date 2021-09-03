package com.gabriellazar.kafkaconsumer.repository;

import com.gabriellazar.kafkaconsumer.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private final String INSERT_EMPLOYEE = "INSERT INTO employees(first_name,last_name,email,phone_number,hire_date,job_id,salary,manager_id,department_id) " +
            "VALUES(:firstName,:lastName,:email,:phoneNumber,:hireDate,:jobId,:salary,:managerId,:departmentId);";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void insertEmployee(final Employee employee) {
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("firstName", employee.getFirstName());
            param.put("lastName", employee.getLastName());
            param.put("email", employee.getEmail());
            param.put("phoneNumber", employee.getPhoneNumber());
            param.put("hireDate", employee.getHireDate());
            param.put("jobId", employee.getJobId());
            param.put("salary", employee.getSalary());
            param.put("managerId", employee.getManagerId());
            param.put("departmentId", employee.getDepartmentId());
            namedParameterJdbcTemplate.update(INSERT_EMPLOYEE, param);
        } catch (DataAccessException e) {
            log.error("Error saving employee :: {} DataAccessException is :: {}",employee,e);
        }

    }


}
