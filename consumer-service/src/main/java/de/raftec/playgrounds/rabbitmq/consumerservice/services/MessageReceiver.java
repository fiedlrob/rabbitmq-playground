package de.raftec.playgrounds.rabbitmq.consumerservice.services;

public interface MessageReceiver {
    void receive(String message);
}
