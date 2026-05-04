# AlgoCore Backend Toolkit

> Bridging the gap between algorithmic problem-solving and real-world backend engineering.

---

## Overview

**AlgoCore** is a Java library that maps fundamental computer science algorithms to practical backend use cases. Each component is written with production habits in mind: clean interfaces, defensive validation, and full unit test coverage.

---

## Modules

| Module | Class | Backend Analogy |
|---|---|---|
| `cache` | `SimpleCache<K,V>` | In-memory key-value store (Redis-like) |
| `search` | `BinarySearchService` | Indexed column lookup in a relational DB |
| `queue` | `OrderQueue` | Task/message queue (RabbitMQ / Kafka consumer) |
| `matching` | `TwoSumService` | Complementary order matching in trading systems |
| `sorting` | `TransactionSorter` | Ledger ordering in payment processing |

---

## Tech Stack

- **Java 17**
- **JUnit 5** — unit testing
- **Maven** — build & dependency management

---

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+

### Build & test
```bash
mvn clean verify
```

### Run tests only
```bash
mvn test
```

---

## Module Details

### SimpleCache
HashMap-backed generic cache with get / put / invalidate / clear operations.

```java
SimpleCache<String, Integer> cache = new SimpleCache<>();
cache.put("user:42", 100);
Integer value = cache.get("user:42"); // 100
```

### BinarySearchService
O(log n) search over sorted arrays. Includes `searchFirst` for duplicate-safe lookups.

```java
BinarySearchService bss = new BinarySearchService();
int index = bss.search(new int[]{1, 3, 5, 7, 9}, 7); // 3
```

### OrderQueue
FIFO queue with null/blank order validation and non-destructive `peek`.

```java
OrderQueue queue = new OrderQueue();
queue.addOrder("ORDER-001");
String next = queue.processOrder(); // "ORDER-001"
```

### TwoSumService
O(n) pair-finding via HashMap. Returns indices or a boolean shorthand.

```java
TwoSumService service = new TwoSumService();
int[] pair = service.findPair(new int[]{2, 7, 11, 15}, 9); // [0, 1]
```

### TransactionSorter
Ascending / descending sort and top-N extraction. Non-mutating — original array is never modified.

```java
TransactionSorter sorter = new TransactionSorter();
int[] top3 = sorter.topN(new int[]{10, 80, 30, 70, 50}, 3); // [80, 70, 50]
```

---

## Project Goal

This project demonstrates that algorithmic knowledge is not just for interview whiteboards —  
it is the foundation of the components that power real backend systems every day.

---

## Author

Built as a portfolio project to showcase applied data structures and backend engineering fundamentals.
