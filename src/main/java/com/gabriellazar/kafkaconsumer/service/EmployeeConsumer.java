package com.gabriellazar.kafkaconsumer.service;

import com.gabriellazar.kafkaconsumer.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeConsumer {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-Id}", containerFactory = "kafkaListenerContainerFactory")
    public void listenEmployee(final Employee employee) {
        try {
            log.info("Employee consumer :: {}", employee.toString());
        } catch (Exception e) {
            log.error("Couldn't consume employee :: {}", employee);
            log.error("Exception in employee consumer :: {}", e);
        }
    }
}
