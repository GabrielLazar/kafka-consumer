package com.gabriellazar.kafkaconsumer.service;

import com.gabriellazar.kafkaconsumer.model.Employee;
import com.gabriellazar.kafkaconsumer.repository.IEmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeConsumer {

    private IEmployeeRepository employeeRepository;

    public EmployeeConsumer(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-Id}", containerFactory = "kafkaListenerContainerFactory")
    public void saveEmployee(final Employee employee) {
        try {
            log.info("Employee consumer :: {}", employee.toString());
            employeeRepository.insertEmployee(employee);
        } catch (Exception e) {
            log.error("Couldn't consume employee :: {}", employee);
            log.error("Exception in employee consumer :: {}", e);
        }
    }
}
