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
import com.customer.publisher.kafka.dto.CustomerDto;

@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, CustomerDto> producerFactory() {
		Map<String, Object> configProperties = new HashMap<>();

		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				JsonSerializer.class);

		return new DefaultKafkaProducerFactory<String, CustomerDto>(
				configProperties);
	}

	@Bean
	public KafkaTemplate<String, CustomerDto> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
