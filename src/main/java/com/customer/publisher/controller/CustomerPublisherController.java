package com.customer.publisher.controller;

import java.security.Principal;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.customer.publisher.domain.CustomerRequest;
import com.customer.publisher.service.PublisherService;

@RestController
@RequestMapping("/customer")
public class CustomerPublisherController {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerPublisherController.class);

  @Autowired
  private PublisherService customerService;

  @PostMapping(path = "/createCustomer")
  public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customer) {
    LOG.info("incomingCustomerrequest {}", customer);
    ResponseEntity<?> responseEntity = customerService.create(customer);
    LOG.info("outGoingCustomerrequest {}", responseEntity.getBody());
    return responseEntity;
  }

  @RequestMapping("/")
  public Principal index(Principal principal) {
    return principal;
  }
}
