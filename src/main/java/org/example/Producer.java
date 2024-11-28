// credits: https://github.com/chrissearle/kafka-java-to-scala/blob/master/java-starter/producer/src/main/java/net/chrissearle/kafka/BasicProducer.java
package org.example;

import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

    public static final String TOPIC = "students";

    public static void main(String[] args) {

        System.out.println("*** Starting Basic Producer ***");

        Properties settings = new Properties();

        settings.put("client.id", "students");
        settings.put("bootstrap.servers", "localhost:9092");
        settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(settings)) {
            String[] names = {"John", "Jack", "Michael", "Mehmet", "Rick", "Susan", "Samantha", "John", "Bob", "Jack"};
            ObjectMapper om = new ObjectMapper();
            for (int i = 1; i <= 10; i++) {
                final String key = "key-" + i;
                Student s = new Student(i, names[i-1]);
                String value = om.writeValueAsString(s);
                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, key, value);

                System.out.println("### Sending " + i + " ###");

                producer.send(record);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}