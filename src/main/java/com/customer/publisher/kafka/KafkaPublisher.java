package com.customer.publisher.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.customer.publisher.domain.CustomerRequest;
import com.customer.publisher.domain.ErrorResponse;
import com.customer.publisher.domain.SucessResponse;

@Configuration
public class KafkaPublisher {

	private static final Logger LOG = LoggerFactory
			.getLogger(KafkaPublisher.class);

	@Autowired
	private KafkaTemplate<String, CustomerRequest> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;

	private ResponseEntity<?> response = null;

	public ResponseEntity<?> publishMessage(String topic,
			CustomerRequest object) {
		LOG.info("topic {}", topic);
		LOG.info("jsonMessage {}", object);

		ListenableFuture<SendResult<String, CustomerRequest>> listenableFuture = kafkaTemplate
				.send(topic, object);

		listenableFuture.addCallback(
				new ListenableFutureCallback<SendResult<String, CustomerRequest>>() {

					@Override
					public void onSuccess(
							final SendResult<String, CustomerRequest> object) {
						SucessResponse sucessResponse = new SucessResponse();
						sucessResponse.setStatus("sucess");
						sucessResponse.setMessage("Post message successfully");
						LOG.info("sent message= " + object);
						response = new ResponseEntity<>(sucessResponse,
								HttpStatus.OK);
					}


					@Override
					public void onFailure(final Throwable throwable) {
						ErrorResponse errorResponse = new ErrorResponse();
						errorResponse.setStatus("failed");
						errorResponse
								.setMessage("Message failed to kafka topic");
						errorResponse.errorType(
								throwable.getClass().getSimpleName());
						System.out.println(object);
						response = new ResponseEntity<>(errorResponse,
								HttpStatus.INTERNAL_SERVER_ERROR);
						LOG.error("unable to send message= " + object,
								throwable);

					}
				});
		kafkaTemplate.flush();
		return response;
	}

	public void publishMessage(String topic, String object) {
		LOG.info("topic {}", topic);
		LOG.info("jsonMessage {}", object);

		kafkaStringTemplate.send(topic, object);
	}

}
