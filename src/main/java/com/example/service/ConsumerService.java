package com.example.service;

import com.example.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ConsumerService {
    private final MessageService messageService;

    public ConsumerService(MessageService messageService){
        this.messageService = messageService;
    }

    @KafkaListener(topics = "javatopic", groupId = "myGroup")
    public void consume(Message jsonMessage) {
        log.info("JSON message received {}",jsonMessage);
        this.messageService.saveMessage(String.valueOf(jsonMessage));
    }

    private Message deserializeJson(String jsonMessage){
        return new Message(jsonMessage);
    }
}
