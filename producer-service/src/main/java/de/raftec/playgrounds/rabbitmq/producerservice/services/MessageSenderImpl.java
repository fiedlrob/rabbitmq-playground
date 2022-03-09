package de.raftec.playgrounds.rabbitmq.producerservice.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImpl implements MessageSender {
    private final RabbitTemplate template;
    private final Queue queue;

    public MessageSenderImpl(RabbitTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
    }

    @Override
    public void sendMessage(String message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println("Sent -> '" + message + "'");
    }
}
