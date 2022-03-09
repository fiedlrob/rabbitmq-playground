package de.raftec.playgrounds.rabbitmq.producerservice.controller;

import de.raftec.playgrounds.rabbitmq.producerservice.services.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messagesender")
@Slf4j
public class SenderController {
    private final MessageSender messageSender;

    public SenderController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        messageSender.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
