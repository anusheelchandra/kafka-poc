package com.kafka.kafkastreaming;

import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

public class BaseContainerTest {

    public static DockerComposeContainer<?> container = new DockerComposeContainer<>(
            new File("docker/docker-compose.yml"));

    static {
        container.start();
    }

}

