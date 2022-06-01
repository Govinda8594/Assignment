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
import com.customer.publisher.domain.ErrorResponse;
import com.customer.publisher.domain.SucessResponse;
import com.customer.publisher.kafka.dto.CustomerDto;

@Configuration
public class KafkaPublisher {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaPublisher.class);

  @Autowired
  private KafkaTemplate<String, CustomerDto> kafkaTemplate;

  private ResponseEntity<?> response = null;

  public ResponseEntity<?> publishMessage(String topic, CustomerDto customerDto) {
    LOG.info("********Kafka Topic************ {}", topic);
    LOG.info("*******Kafka JsonMesg************* {}", customerDto);

    ListenableFuture<SendResult<String, CustomerDto>> listenableFuture =
        kafkaTemplate.send(topic, customerDto);

    listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, CustomerDto>>() {

      @Override
      public void onSuccess(final SendResult<String, CustomerDto> object) {
        SucessResponse sucessResponse = new SucessResponse();
        sucessResponse.setStatus("sucess");
        sucessResponse.setMessage("Post message successfully");
        LOG.info("******MESSAGE SENT TO KAFKA SUCCESSFULL******* " + object);
        response = new ResponseEntity<>(sucessResponse, HttpStatus.OK);
      }


      @Override
      public void onFailure(final Throwable throwable) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus("failed");
        errorResponse.setMessage("Message failed to kafka topic");
        errorResponse.errorType(throwable.getClass().getSimpleName());
        LOG.error("**** KAFKA ERROR*****NOT ABLE TO SEND MESSAGE******" + customerDto, throwable);
        response = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

      }
    });
    kafkaTemplate.flush();
    return response;
  }
}
