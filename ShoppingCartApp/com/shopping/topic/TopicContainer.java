package com.shopping.topic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TopicContainer {

    BlockingQueue<Message> container ;
    int size;

    public TopicContainer(BlockingQueue<Message> container, int size) {
        this.container = container;
        this.size = size;
    }

    public boolean isFull(){
        return container.size() == size;
    }

    public BlockingQueue<Message> getContainer() {
        return container;
    }

    public void setContainer(BlockingQueue<Message> container) {
        this.container = container;
    }

    public void putMessage(Message t){
        container.add(t);
    }

    public Message getMessage() throws InterruptedException {
        Message t = container.poll(10, TimeUnit.SECONDS);
        container.remove(t);
        return t;
    }
}
