// package com.customer.publisher;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// import java.util.Map;
// import java.util.concurrent.BlockingQueue;
// import java.util.concurrent.LinkedBlockingQueue;
// import java.util.concurrent.TimeUnit;
//
// import org.apache.kafka.clients.consumer.ConsumerRecord;
// import org.junit.jupiter.api.Test;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
// import org.springframework.kafka.core.DefaultKafkaProducerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.core.ProducerFactory;
// import org.springframework.kafka.listener.KafkaMessageListenerContainer;
// import org.springframework.kafka.listener.MessageListener;
// import org.springframework.kafka.test.utils.ContainerTestUtils;
// import org.springframework.kafka.test.utils.KafkaTestUtils;
//
// public class KafkaTemplateTests {
//
// private static final String TEMPLATE_TOPIC = "templateTopic";
//
// @ClassRule
// public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true,
// TEMPLATE_TOPIC);
//
// @Test
// public void testTemplate() throws Exception {
// Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testT",
// "false", embeddedKafka);
// DefaultKafkaConsumerFactory<Integer, String> cf =
// new DefaultKafkaConsumerFactory<Integer, String>(consumerProps);
// KafkaMessageListenerContainer<Integer, String> container =
// new KafkaMessageListenerContainer<>(cf, TEMPLATE_TOPIC);
// final BlockingQueue<ConsumerRecord<Integer, String>> records = new
// LinkedBlockingQueue<>();
// container.setMessageListener(new MessageListener<Integer, String>() {
//
// @Override
// public void onMessage(ConsumerRecord<Integer, String> record) {
// System.out.println(record);
// records.add(record);
// }
//
// });
// container.setBeanName("templateTests");
// container.start();
// ContainerTestUtils.waitForAssignment(container,
// embeddedKafka.getPartitionsPerTopic());
// Map<String, Object> senderProps = KafkaTestUtils.senderProps(embeddedKafka);
// ProducerFactory<Integer, String> pf =
// new DefaultKafkaProducerFactory<Integer, String>(senderProps);
// KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf);
// template.setDefaultTopic(TEMPLATE_TOPIC);
// template.syncConvertAndSend("foo");
// assertThat(records.poll(10, TimeUnit.SECONDS), hasValue("foo"));
// template.syncConvertAndSend(0, 2, "bar");
// ConsumerRecord<Integer, String> received = records.poll(10,
// TimeUnit.SECONDS);
// assertThat(received, hasKey(2));
// assertThat(received, hasPartition(0));
// assertThat(received, hasValue("bar"));
// template.syncConvertAndSend(TEMPLATE_TOPIC, 0, 2, "baz");
// received = records.poll(10, TimeUnit.SECONDS);
// assertThat(received, hasKey(2));
// assertThat(received, hasPartition(0));
// assertThat(received, hasValue("baz"));
// }
//
// }