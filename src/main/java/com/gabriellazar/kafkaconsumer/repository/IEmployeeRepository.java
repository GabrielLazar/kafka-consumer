package com.gabriellazar.kafkaconsumer.repository;

import com.gabriellazar.kafkaconsumer.model.Employee;

public interface IEmployeeRepository {
    void insertEmployee(Employee employee);
}
