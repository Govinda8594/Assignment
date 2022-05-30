package com.customer.publisher.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.customer.publisher.domain.CustomerRequest;

@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, CustomerRequest> producerFactory() {
		Map<String, Object> configProperties = new HashMap<>();

		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				JsonSerializer.class);

		return new DefaultKafkaProducerFactory<String, CustomerRequest>(
				configProperties);
	}

	@Bean
	public KafkaTemplate<String, CustomerRequest> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, String> producerStringFactory() {
		Map<String, Object> configProperties = new HashMap<>();

		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);

		return new DefaultKafkaProducerFactory<>(configProperties);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaStringTemplate() {
		return new KafkaTemplate<>(producerStringFactory());
	}

}
