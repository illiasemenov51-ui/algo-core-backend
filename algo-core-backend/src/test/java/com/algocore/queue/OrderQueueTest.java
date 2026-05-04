package com.algocore.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderQueueTest {

    @Test
    void addAndProcess_fifoOrder() {
        OrderQueue q = new OrderQueue();
        q.addOrder("ORDER-001");
        q.addOrder("ORDER-002");
        assertEquals("ORDER-001", q.processOrder());
        assertEquals("ORDER-002", q.processOrder());
    }

    @Test
    void processOrder_emptyQueue_returnsNull() {
        OrderQueue q = new OrderQueue();
        assertNull(q.processOrder());
    }

    @Test
    void peek_doesNotRemoveOrder() {
        OrderQueue q = new OrderQueue();
        q.addOrder("ORDER-003");
        q.peek();
        assertFalse(q.isEmpty());
    }

    @Test
    void addOrder_blankOrder_throwsException() {
        OrderQueue q = new OrderQueue();
        assertThrows(IllegalArgumentException.class, () -> q.addOrder("  "));
    }
}
