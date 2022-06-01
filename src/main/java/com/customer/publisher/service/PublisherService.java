package com.customer.publisher.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.customer.publisher.domain.CustomerRequest;

public interface PublisherService {

	ResponseEntity<?> create(@Valid CustomerRequest customer);

}
