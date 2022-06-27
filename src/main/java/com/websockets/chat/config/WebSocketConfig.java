package com.websockets.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // встановлюємо початок шляху для веб-сокет зєднання і дозволяємо ресурси з цсіх джерел
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //встановлюємо префікс призначення для додатку за яким будуть відправлятися дані на сервер
        registry.setApplicationDestinationPrefixes("/app");
        // встановлюємо префікси тем
        registry.enableSimpleBroker("/chatroom", "/user");
        // встановлюємо префікси призначення для користувача
        registry.setUserDestinationPrefix("/user");
    }
}
