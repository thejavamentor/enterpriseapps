package com.shopping.topic;

import java.util.HashMap;
import java.util.Map;

public class Message {
    String messageId;
    //Type<> message;
    Map<String, Object> messageHeaders;

    public void init(){
        messageHeaders = new HashMap<String, Object>();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
