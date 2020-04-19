package com.example.activemq.server.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;

@Log4j2
public class JmsListenerService {

    @JmsListener(destination = "simple.queue")
    public void receive(String message) {
        log.info("received message='{}'", message);
    }
}
