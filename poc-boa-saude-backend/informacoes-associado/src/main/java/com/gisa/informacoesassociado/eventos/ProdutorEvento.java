package com.gisa.informacoesassociado.eventos;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

@Slf4j
public class ProdutorEvento {

    private final Producer<String, String> producer;

    public ProdutorEvento() {
        producer = criarProducer();
    }

    private Producer<String, String> criarProducer() {
        if (producer != null) {
            return producer;
        }

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
        return new KafkaProducer<String, String>(properties);
    }

    public boolean enviarMsgRegistroMedico(String topico, String mensagem) {
        String chave = UUID.randomUUID().toString();
        log.info(">>> Iniciando envio da mensagem do tópico [{}]", topico);
        log.info(">>> Mensagem: [{}]", mensagem);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topico, chave, mensagem);
        producer.send(record);
        producer.flush();
        producer.close();
        log.info("Mensagem enviada com sucesso!");
        return true;
    }
}
