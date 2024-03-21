package com.example.endpoint;

import com.example.model.Message;
import com.example.service.ProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaEndpoint {

    private final ProducerService producer;

    public KafkaEndpoint(ProducerService producer){
        this.producer = producer;
    }

    @PostMapping("/send")
    public void sendMassage(@RequestBody Message message){
        producer.sendMessage(message);

    }


}
