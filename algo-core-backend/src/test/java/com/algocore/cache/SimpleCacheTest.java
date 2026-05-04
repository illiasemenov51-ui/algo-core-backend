package com.algocore.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCacheTest {

    private SimpleCache<String, Integer> cache;

    @BeforeEach
    void setUp() {
        cache = new SimpleCache<>();
    }

    @Test
    void putAndGet_returnsStoredValue() {
        cache.put("user:1", 42);
        assertEquals(42, cache.get("user:1"));
    }

    @Test
    void get_missingKey_returnsNull() {
        assertNull(cache.get("missing"));
    }

    @Test
    void contains_existingKey_returnsTrue() {
        cache.put("session:abc", 1);
        assertTrue(cache.contains("session:abc"));
    }

    @Test
    void invalidate_removesKey() {
        cache.put("token:xyz", 99);
        cache.invalidate("token:xyz");
        assertFalse(cache.contains("token:xyz"));
    }

    @Test
    void clear_emptiesCache() {
        cache.put("a", 1);
        cache.put("b", 2);
        cache.clear();
        assertEquals(0, cache.size());
    }
}
