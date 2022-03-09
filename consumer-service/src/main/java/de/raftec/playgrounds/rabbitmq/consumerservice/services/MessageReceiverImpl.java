package de.raftec.playgrounds.rabbitmq.consumerservice.services;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "playground.simple.queue")
public class MessageReceiverImpl implements MessageReceiver {
    @RabbitHandler
    @Override
    public void receive(String message) {
        System.out.println("Received <- '" + message + "'");
    }
}
