package com.websockets.chat.controllers;

import com.websockets.chat.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    // отримує дані для чату і надсилає повідомлення до відповідної теми чату

    // дозволяє динамічно створювати адресу
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // метод на адресі /app/message
    @MessageMapping("/message")
    // надсилає дані на адресу /app/chatroom/public
    @SendTo("/chatroom/public")
    private Message receivePublicMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message) {
        // автоматично надсилає на адресу /user з UserDestinationPrefix, /імя користувача і /private
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        return message;
    }
}
