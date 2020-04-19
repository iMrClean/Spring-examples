package com.example.activemq.client.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ClientServiceImpl implements ClientService {

    @Value("${my.queue}")
    private String queue;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public ClientServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendMessage(String message) {
        log.info("sending message = {}", message);
        jmsTemplate.convertAndSend(queue, message);
        log.info("done");
    }
}
