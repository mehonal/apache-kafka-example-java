// credits: https://github.com/chrissearle/kafka-java-to-scala/blob/master/java-starter/producer/src/main/java/net/chrissearle/kafka/BasicProducer.java
package org.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

    public static final String TOPIC = "hello-world-topic";

    public static void main(String[] args) {

        System.out.println("*** Starting Basic Producer ***");

        Properties settings = new Properties();

        settings.put("client.id", "basic-producer");
        settings.put("bootstrap.servers", "localhost:9092");
        settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(settings)) {
            for (int i = 1; i <= 5; i++) {
                final String key = "key-" + i;
                final String value = "value-" + i;

                System.out.println("### Sending " + i + " ###");

                producer.send(new ProducerRecord<>(TOPIC, key, value));
            }
        }
    }
}