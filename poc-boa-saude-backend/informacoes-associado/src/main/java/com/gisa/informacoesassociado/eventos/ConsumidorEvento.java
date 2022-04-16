package com.gisa.informacoesassociado.eventos;

import com.gisa.informacoesassociado.dao.RegistroMedicoDao;
import com.gisa.informacoesassociado.model.RegistroMedicoModel;
import com.gisa.informacoesassociado.service.RegistroMedicoService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;

@Slf4j
@Component
public class ConsumidorEvento implements CommandLineRunner {

    private final KafkaConsumer<String, String> consumer;

    @Autowired
    private RegistroMedicoDao registroMedicoDao;

    @Autowired
    private RegistroMedicoService registroMedicoService;

    public ConsumidorEvento() {
        consumer = criarConsumer();
    }

    private KafkaConsumer<String, String> criarConsumer() {
        if (consumer != null) {
            return consumer;
        }
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "default");
        return new KafkaConsumer<String, String>(properties);
    }

    public void receberMensagens(String topico) {
        List<String> topicos = new ArrayList<>();
        topicos.add(topico);
        consumer.subscribe(topicos);

        log.info("Iniciando consumer de mensagens...");
        boolean continuar = true;
        while (continuar) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
            for (ConsumerRecord<String, String> record : records) {
                gravarMensagemBancoDados(record.topic(), record.partition(), record.value());
                if (record.value().equals("FECHAR")) {
                    continuar = false;
                }
            }
        }
        consumer.close();
    }

    private void gravarMensagemBancoDados(String topico, int particao, String mensagem) {
        log.info("Topico:{}, Partição:{}, Mensagem:{}", topico, particao, mensagem);
        final String REGISTRO_MEDICO = "RegistroMedico";

        if (topico.equals(REGISTRO_MEDICO)) {
            Gson gson = new Gson();
            RegistroMedicoModel registroMedico = gson.fromJson(mensagem, RegistroMedicoModel.class);
            log.info("registroMedico: {}", registroMedico);
            registroMedicoService.salvar(registroMedico);
        } else {
            log.error("Mensagem não reconhecida para gravar no banco de dados!");
            return;
        }
        log.info("Mensagem gravada com sucesso!");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(">>>>> Iniciando o consumidor de eventos");
        receberMensagens("RegistroMedico");
    }
}
