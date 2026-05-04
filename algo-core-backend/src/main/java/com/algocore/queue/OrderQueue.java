package com.algocore.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A FIFO order processing queue.
 * Models task/message queues used in systems like RabbitMQ or Kafka consumers.
 */
public class OrderQueue {

    private final Queue<String> queue = new LinkedList<>();

    /**
     * Enqueue a new order for processing.
     *
     * @param order order identifier or payload
     */
    public void addOrder(String order) {
        if (order == null || order.isBlank()) {
            throw new IllegalArgumentException("Order cannot be null or empty");
        }
        queue.add(order);
    }

    /**
     * Dequeue and return the next order to process.
     *
     * @return order string, or null if queue is empty
     */
    public String processOrder() {
        return queue.poll();
    }

    /**
     * Inspect the next order without removing it.
     *
     * @return next order string, or null if queue is empty
     */
    public String peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
