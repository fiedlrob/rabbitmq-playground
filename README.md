# rabbitmq-playground

Playground to experiment with Spring Boot and RabbitMQ

## RabbitMQ broker

To start the broker issue the following command:

    docker-compose up

This will start the RabbitMQ broker in a docker container. You can access this instance via http://localhost:15672. We haven't changed the default user namename and password so the instance can be accessed with *guest:guest*.

If you want to change the username and password you can modify the docker-compose.yml and add the following section:

    environment:
      RABBITMQ_DEFAULT_USER: [USERNAME]
      RABBITMQ_DEFAULT_PASS: [PASSWORD]
