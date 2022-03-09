package de.raftec.playgrounds.rabbitmq.consumerservice.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReceiverRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- RECEIVER STARTED ---");
    }
}
