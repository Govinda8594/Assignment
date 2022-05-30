package com.customer.publisher.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.publisher.domain.CustomerRequest;
import com.customer.publisher.kafka.KafkaPublisher;
import com.customer.publisher.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	private static final Logger LOG = LoggerFactory
			.getLogger(PublisherServiceImpl.class);

	@Autowired
	private KafkaPublisher kafkaPublisher;

	@Override
	public ResponseEntity<?> create(CustomerRequest customer) {
		LOG.info("inCustomerservice {}", customer);
		
		return kafkaPublisher.publishMessage("customer-2", customer);

	}

	@Override
	public void sendString(String customer) {
		kafkaPublisher.publishMessage("customer-1", customer);

	}

	// @Override
	// public Object deleteCustomer(String firstName) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Object getCustomerByName(String firstName) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Object updateCustomer(String firstName,
	// @Valid CustomerRequest body) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
