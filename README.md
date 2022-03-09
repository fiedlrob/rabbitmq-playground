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

## Run sample

To start the sample services issue the following commands:

### Start producer-service
    ./gradlew producer-service:bootRun

You should see the following output 
    
    > Task :producer-service:bootRun
    14:01:07.423  [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@1715ad25

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::                (v2.6.4)

### Start consumer-service
    ./gradlew consumer-service:bootRun

You should see the following output

    > Task :consumer-service:bootRun
    14:01:12.241 [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@c1e8df5

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::                (v2.6.4)

    --- RECEIVER STARTED ---

### Send message

To test the functionality you have to POST a message to the *producer-service*.
Issue the following command to do so

    curl -X POST -H "Content-Type: text/plain" --data "Hello RabbitMQ" localhost:8080/messagesender

If you look at the output of producer-service you wille see 

    > Task :producer-service:bootRun
    14:01:07.423  [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@1715ad25

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::                (v2.6.4)

    Sent -> 'Hello RabitMQ'


and the consumer-service will show the following

    > Task :consumer-service:bootRun
    14:01:12.241 [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@c1e8df5

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::                (v2.6.4)

    --- RECEIVER STARTED ---
    Received <- 'Hello RabitMQ'

As you can see a message was send from the producer-service  and received by the consumer-service.

