# algo-core-backend
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

# ⚡ AlgoCore Backend Toolkit

<div align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Tests](https://img.shields.io/badge/Tests-Passing-brightgreen?style=for-the-badge)

**Алгоритмы — не только для whiteboard-собеседований.**  
*AlgoCore доказывает: каждая структура данных живёт в реальном бэкенде.*

[🐍 Демо: Змейка (Queue)](#-интерактивные-демо) • [🧱 Демо: Тетрис (Stack)](#-интерактивные-демо) • [🔍 Демо: Бинарный поиск](#-интерактивные-демо)

</div>

---

## 🗺 Обзор

**AlgoCore** — библиотека на Java, которая показывает связь фундаментальных алгоритмов с реальными бэкенд-паттернами. Каждый модуль — это не просто «задача с LeetCode», а компонент, который вы встретите в production.

```
алгоритм               →    реальная система
──────────────────────────────────────────────
Queue (FIFO)           →    Kafka / RabbitMQ consumer
Binary Search O(log n) →    Indexed DB lookup
HashMap matching O(n)  →    Trading order matching
Sort O(n log n)        →    Payment ledger ordering
HashMap cache          →    Redis / in-memory TTL-кэш
```

---

## 📦 Модули

| Модуль | Класс | Аналог в бэкенде | Сложность |
|--------|-------|------------------|-----------|
| `cache` | `SimpleCache<K,V>` | In-memory store (Redis) | O(1) get/put |
| `search` | `BinarySearchService` | Indexed column lookup | O(log n) |
| `queue` | `OrderQueue` | RabbitMQ / Kafka consumer | O(1) enqueue |
| `matching` | `TwoSumService` | Trading order matching | O(n) |
| `sorting` | `TransactionSorter` | Payment ledger ordering | O(n log n) |

---

## 🎮 Интерактивные демо

> Три игры, которые визуализируют алгоритмы из этого репозитория в действии.

### 🐍 Змейка → `OrderQueue`
Тело змейки — это **FIFO-очередь**: голова добавляется спереди (`addOrder`), хвост убирается сзади (`processOrder`). Именно так Kafka обрабатывает сообщения.

```bash
open demo/snake.html
```

### 🧱 Тетрис → Stack
Упавшие строки — это **стек**: последний добавленный — первый удаляемый при очистке линий. Аналог call stack или undo-history.

```bash
open demo/tetris.html
```

### 🔍 Визуализатор бинарного поиска → `BinarySearchService`
Интерактивная анимация шагов `search()` и `searchFirst()` на отсортированном массиве. Видно каждое деление пополам — O(log n) в действии.

```bash
open demo/binary-search.html
```

---

## 🚀 Быстрый старт

### Требования
- Java 17+
- Maven 3.8+

### Сборка и тесты
```bash
git clone https://github.com/your-username/algo-core-backend.git
cd algo-core-backend

# Собрать и прогнать все тесты
mvn clean verify

# Только тесты
mvn test

# Запустить конкретный тест
mvn test -Dtest=BinarySearchServiceTest
```

---

## 📖 Документация модулей

### 🗄 SimpleCache
HashMap-backed generic кэш с базовыми CRUD-операциями.  
**Реальный аналог**: Redis, Guava Cache, Caffeine.

```java
SimpleCache<String, Integer> cache = new SimpleCache<>();
cache.put("session:abc123", 42);

Integer val = cache.get("session:abc123"); // 42
boolean hit  = cache.contains("session:abc123"); // true

cache.invalidate("session:abc123"); // ручная инвалидация
cache.clear();                      // flush all
```

---

### 🔎 BinarySearchService
O(log n) поиск по отсортированному массиву. `searchFirst` корректно работает с дублями.  
**Реальный аналог**: B-Tree индекс в PostgreSQL, `Collections.binarySearch`.

```java
BinarySearchService bss = new BinarySearchService();

int idx   = bss.search(new int[]{1, 3, 5, 7, 9}, 7);       // → 3
int first = bss.searchFirst(new int[]{2, 4, 4, 4, 8}, 4);  // → 1
```

| n | Итераций max |
|---|-------------|
| 1 000 | 10 |
| 1 000 000 | 20 |
| 1 000 000 000 | 30 |

---

### 📬 OrderQueue
FIFO-очередь с валидацией. Non-destructive `peek`.  
**Реальный аналог**: очередь задач в Celery, consumer-группа Kafka.

```java
OrderQueue queue = new OrderQueue();
queue.addOrder("ORDER-001");
queue.addOrder("ORDER-002");

queue.peek();          // "ORDER-001" — не удаляет
queue.processOrder();  // "ORDER-001" — удаляет
queue.size();          // 1
```

> `addOrder(null)` и `addOrder("")` бросают `IllegalArgumentException`

---

### 🔗 TwoSumService
O(n) поиск пары с нужной суммой через HashMap.  
**Реальный аналог**: матчинг заявок buy/sell в торговом движке.

```java
TwoSumService service = new TwoSumService();

int[] pair   = service.findPair(new int[]{2, 7, 11, 15}, 9); // → [0, 1]
boolean exists = service.hasPair(new int[]{1, 4, 6, 8}, 10); // → true
int[] none   = service.findPair(new int[]{1, 2, 3}, 100);    // → [-1, -1]
```

---

### 💳 TransactionSorter
Non-mutating сортировка транзакций с top-N выборкой.  
**Реальный аналог**: сортировка операций в банковской выписке.

```java
TransactionSorter sorter = new TransactionSorter();
int[] txns = {10, 80, 30, 70, 50};

sorter.sortTransactions(txns); // → [10, 30, 50, 70, 80]
sorter.sortDescending(txns);   // → [80, 70, 50, 30, 10]
sorter.topN(txns, 3);          // → [80, 70, 50]
// исходный массив не изменён!
```

---

## 🧪 Покрытие тестами

```
OrderQueueTest          ✓  enqueue/dequeue, peek, empty, validation
BinarySearchServiceTest ✓  found, not found, duplicates, edge cases
SimpleCacheTest         ✓  put/get, miss, invalidate, clear
TwoSumServiceTest       ✓  pair found, no pair, hasPair
TransactionSorterTest   ✓  ascending, descending, topN, immutability
```

```bash
mvn test
# BUILD SUCCESS — Tests run: N, Failures: 0, Errors: 0
```

---

## 🏗 Структура проекта

```
algo-core-backend/
├── src/
│   ├── main/java/com/algocore/
│   │   ├── cache/       SimpleCache.java
│   │   ├── search/      BinarySearchService.java
│   │   ├── queue/       OrderQueue.java
│   │   ├── matching/    TwoSumService.java
│   │   └── sorting/     TransactionSorter.java
│   └── test/java/com/algocore/
│       ├── cache/       SimpleCacheTest.java
│       ├── search/      BinarySearchServiceTest.java
│       ├── queue/       OrderQueueTest.java
│       ├── matching/    TwoSumServiceTest.java
│       └── sorting/     TransactionSorterTest.java
├── demo/
│   ├── snake.html           🐍 Queue visualizer
│   ├── tetris.html          🧱 Stack visualizer
│   └── binary-search.html   🔍 Binary search visualizer
├── pom.xml
└── README.md
```

---

## 💡 Философия проекта

> *«Хорошему бэкенд-разработчику не нужно помнить все алгоритмы наизусть.  
> Ему нужно понимать, где они живут в его коде — уже сейчас.»*

- `HashMap` внутри вашего Spring-сервиса — это TwoSum.
- Очередь сообщений в Kafka — это OrderQueue.
- Индекс в PostgreSQL работает как BinarySearchService.
- История запросов пользователя — это Stack.

---

## 👤 Автор

Портфолио-проект для демонстрации applied data structures и основ бэкенд-инжиниринга.

[![GitHub](https://img.shields.io/badge/GitHub-Profile-181717?style=for-the-badge&logo=github)](https://github.com/your-username)

---
