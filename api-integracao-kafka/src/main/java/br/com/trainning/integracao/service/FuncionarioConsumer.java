package br.com.trainning.integracao.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioConsumer {

    @KafkaListener(topics = "TopicA", groupId = "groupId")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }
}
