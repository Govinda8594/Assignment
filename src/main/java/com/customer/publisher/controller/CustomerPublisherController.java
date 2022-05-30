package com.customer.publisher.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.publisher.domain.CustomerRequest;
import com.customer.publisher.service.PublisherService;

@RestController
public class CustomerPublisherController {

	private static final Logger LOG = LoggerFactory
			.getLogger(CustomerPublisherController.class);

	@Autowired
	private PublisherService customerService;

	@PostMapping(path = "/createCustomer")
	public ResponseEntity<?> createCustomer(
			@Valid @RequestBody CustomerRequest customer) {
		LOG.info("incomingCustomerrequest {}", customer);
		return customerService.create(customer);
	}

	@PostMapping(path = "/sendStringr/{name}")
	public void createCustomer(@PathVariable("name") String customer) {
		LOG.info("incomingCustomerrequest {}", customer);
		customerService.sendString(customer);
	}
	
	
	@GetMapping("/getstring")
	public String gethello() {
		return "Health Check";
	}
	
	@RequestMapping("/")
    public String index(Model model, Principal principal) {
        return "index";
    }
	

	// public ResponseEntity<Void> deleteCustomer(
	// @PathVariable("firstName") String firstName) {
	// LOG.info("incomingCustomerrequest {}", firstName);
	// return new ResponseEntity<>(customerService.deleteCustomer(firstName),
	// HttpStatus.OK);
	// }
	//
	// public ResponseEntity<SucessResponse> getCustomerByName(
	// @PathVariable("firstName") String firstName) {
	// LOG.info("incomingCustomerrequest {}", firstName);
	// return new
	// ResponseEntity<>(customerService.getCustomerByName(firstName),HttpStatus.OK)
	// }
	//
	// public ResponseEntity<Void> updateCustomer(
	// @PathVariable("firstName") String firstName,
	// @Valid @RequestBody CustomerRequest body) {
	// LOG.info("incomingCustomerrequest {}", firstName);
	// LOG.info("incomingCustomerrequestBody {}", body);
	// return new
	// ResponseEntity<>(customerService.updateCustomer(firstName,body),HttpStatus.OK)
	// }

}
