package de.raftec.playgrounds.rabbitmq.producerservice.services;

public interface MessageSender {
    void sendMessage(String message);
}
