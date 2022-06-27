package com.websockets.chat.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    //модель повідомлення
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
