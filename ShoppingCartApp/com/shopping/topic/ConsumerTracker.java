package com.shopping.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConsumerTracker {
    int size;
    Map<String, Integer> consumerMap = new ConcurrentHashMap<>();

    List<String> consumers = new ArrayList();

    public void addConsumer(String consumerId){
         consumers.add(consumerId);
    }

    public boolean readByConsumer(String messageId){
        if(consumerMap.keySet().contains(messageId)) {
            int count = consumerMap.get(messageId);
            count++;
            if (count == consumers.size()) {
                System.out.println("Total consumer read the message, removing from consumer tracker");
                consumerMap.remove(messageId);
            } else {
                consumerMap.put(messageId, count);
            }
            return Boolean.TRUE;
        }
        else {
            consumerMap.put(messageId, 1);
            return Boolean.TRUE;
        }
    }

}
