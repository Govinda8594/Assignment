package com.customer.publisher.advice;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.customer.publisher.exception.CustomerPublisherException;

@RestControllerAdvice
public class CustomerPublisherControllerAdvice
		extends
			ResponseEntityExceptionHandler {
  
  private static final Logger LOG = LoggerFactory
      .getLogger(CustomerPublisherControllerAdvice.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerPublisherException.class)
	public ResponseEntity<Object> customerPublisherExceptionHandler(
			CustomerPublisherException customerPublisherException) {

	    LOG.error("******ERROR HANDLER******* {}",customerPublisherException.getMessage());
		return new ResponseEntity<>(customerPublisherException.getMessage(),
				HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		Map<String, String> maperror = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(
				e -> maperror.put(e.getField(), e.getDefaultMessage()));

        LOG.error("******ERROR HANDLER******* {}",maperror);
		return new ResponseEntity<Object>(maperror,
				HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

      LOG.error("******ERROR HANDLER******* {}","HTTP METHOD INCORRECT");
		return new ResponseEntity<Object>("Please change http method type",
				HttpStatus.METHOD_NOT_ALLOWED);
		
	}

}
