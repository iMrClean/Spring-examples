package com.example.activemq.client.service;

public interface ClientService {

    /**
     * Отправляем сообщение в очередь
     *
     * @param message текст
     */
    void sendMessage(String message);

}
