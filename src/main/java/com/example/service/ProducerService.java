package com.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String,String> kafkaTemplate,ObjectMapper objectMapper){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Object messageObj) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(messageObj);
            log.info("Sending JSON message: {}", jsonMessage);
            kafkaTemplate.send("javatopic", jsonMessage);
        } catch (JsonProcessingException e){
            log.error("Error serializing message to JSON: {}", e.getMessage());
        }
    }
}
