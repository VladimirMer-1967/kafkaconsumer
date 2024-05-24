package com.merkulov.kafkaconsumer.service;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@EnableKafka
@Component
public class MessageListener {

    private static final String KAFKA_TOPIC_NAME = "topic_name";

    private final List<String> messages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics=KAFKA_TOPIC_NAME)
    public void msgListener(String msg){
        System.out.println("Kafka message received: " + msg);
        messages.add(msg);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
