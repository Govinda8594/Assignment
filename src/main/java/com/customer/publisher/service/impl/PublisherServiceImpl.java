package com.customer.publisher.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.customer.publisher.domain.CustomerRequest;
import com.customer.publisher.kafka.KafkaPublisher;
import com.customer.publisher.kafka.dto.CustomerDto;
import com.customer.publisher.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

  private static final Logger LOG = LoggerFactory.getLogger(PublisherServiceImpl.class);

  @Autowired
  private KafkaPublisher kafkaPublisher;

  @Override
  public ResponseEntity<?> create(CustomerRequest customer) {
    LOG.info("******FROM CUSTOMER SERVICE*********** {}", customer);
    CustomerDto customerDto = convertTOkafkaObj(customer);
    LOG.debug("*******PUBLISG MESSAGE TO TOPIC********* {}", customerDto);
    return kafkaPublisher.publishMessage("customer-2", customerDto);

  }

  private CustomerDto convertTOkafkaObj(CustomerRequest customer) {
    CustomerDto customerDto = new CustomerDto();
    BeanUtils.copyProperties(customer, customerDto);
    customerDto.setCustomerStatus(customer.getCustomerStatus().name());
    LOG.debug("*************Json convert to Kafka Json********", customerDto.toString());
    return customerDto;
  }
}
