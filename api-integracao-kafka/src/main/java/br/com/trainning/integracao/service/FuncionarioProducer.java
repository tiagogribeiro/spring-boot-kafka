package br.com.trainning.integracao.service;

import br.com.trainning.integracao.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@ConfigurationProperties("kafka")
public class FuncionarioProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private String topic = "TopicA";

    public void send(Funcionario funcionario){

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, funcionario);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Falha: " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + funcionario +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
