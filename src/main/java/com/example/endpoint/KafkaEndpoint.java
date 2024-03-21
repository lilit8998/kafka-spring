package com.example.endpoint;

import com.example.model.Message;
import com.example.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaEndpoint {

    private final Producer producer;

    public KafkaEndpoint(Producer producer){
        this.producer = producer;
    }

    @PostMapping("/send")
    public void sendMassage(@RequestBody Message message){
        producer.sendMessage(message);

    }


}
