package com.example.service;

import com.example.model.Message;
import com.example.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Transactional
    public void saveMessage(String jsonMessage) {
        Message message1  = new Message();
        message1.setText(jsonMessage);
        messageRepository.save(message1);
    }
}
