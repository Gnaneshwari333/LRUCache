# LRU Cache Implementation in Java

This project implements an **LRU (Least Recently Used) Cache** using Java.  
It supports constant time **O(1)** `get` and `put` operations by combining a **HashMap** with a **Doubly Linked List**.

---

## 🚀 Features

- O(1) time complexity for both `get` and `put`
- Uses:
  - `HashMap` for fast key lookup
  - Doubly Linked List to maintain usage order
- Menu-driven console application
- Automatically evicts the **Least Recently Used** item when capacity is exceeded

---

## 🧠 How It Works

- **Most Recently Used (MRU)** items are kept near the head of the list
- **Least Recently Used (LRU)** items are near the tail
- On every `get` or `put`:
  - The accessed node is moved to the front
- When capacity is exceeded:
  - The tail node (LRU) is removed

---

## 🧩 Data Structures Used

| Structure | Purpose |
|---------|--------|
| `HashMap<Integer, Node>` | Fast access to cache items |
| Doubly Linked List | Maintains LRU order |
| Dummy Head & Tail | Simplifies insert/remove operations |


🖥️ **Sample Interaction**
Enter Cache Capacity: 2
--- LRU Cache Menu ---
1. Put (Add/Update)
2. Get (Retrieve)
3. Exit

📈 **Example Scenario**
put(1, 10)
put(2, 20)
get(1)      → returns 10
put(3, 30)  → evicts key 2

💡 **Why This Design?**

Avoids linear scans

Mirrors real-world cache behavior

Commonly asked in technical interviews

Clean separation of responsibilities

🛠️ **Possible Improvements**

Make cache generic (<K, V>)

Add unit tests

Make thread-safe

Remove console interaction for library use

👩‍💻 **Author**

Gnaneshwari
Java Developer | Data Structures Enthusiast

