package de.raftec.playgrounds.rabbitmq.producerservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue myQueue() {
        return new Queue("playground.simple.queue", false);
    }
}
