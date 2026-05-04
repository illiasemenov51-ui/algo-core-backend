package com.algocore.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * A lightweight in-memory cache backed by HashMap.
 * Conceptually similar to how Redis stores key-value pairs.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SimpleCache<K, V> {

    private final Map<K, V> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public boolean contains(K key) {
        return cache.containsKey(key);
    }

    public void invalidate(K key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public int size() {
        return cache.size();
    }
}
