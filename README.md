# 🏦 Bank Service Demo (Monolith Concept)

This project is a demo of a **bank service** using a **monolithic architecture**.  
All code is consolidated into this project as the core system to **test code design concepts**.

---

## ⚙️ Instructions

1. Setup **Kafka** or **Redis** via docker-compose
2. Setup **Flyway**  
3. Check configuration files  
4. Don’t forget to run: `docker compose up` / `down`  
5. Run the application

---

## 📌 Current Status

- **Auth Service** and **User Service** are currently combined.  
  > Separation into microservices will be decided later.  

- **Transfer Service**: Implements a simple banking transaction concept.

- **`OpenAPI`**: Automatically generates models and **TypeScript REST templates** for Angular.  
  ➤ Just run `mvn build`

- **`Role-based authorization`** is implemented using annotations (e.g., `@PreAuthorize("hasAuthority('TELLER')")`)

- **`JWT` (JSON Web Token)** is used for authentication.

- **Batch schedule service** is in place.

- **Workflow Engine**:  
  ➤ Find `WorkflowRegistry.java`  
  ➤ Designed to configure and implement multiple services with minimal code.  
  ➤ Works like a **state machine**, but fully custom-built.

- Simple REST calls to the **Payment Service** using **`Java Reactive`** concept.

- **`Flyway`** is used for database migration.

- **`Kafka`** is used as a **message queue** and supports the **event-driven** concept.  
  ➤ Subscribed to `workflow-topic`: when data is sent to this queue, the workflow starts automatically.

- **`Redis`** is integrated for experimentation.  
  ➤ Example controllers are included.  
  ➤ Easily expandable to use Redis as a cache or data store.

---

## 🔮 Next Features to Implement

- 🔐 Encrypt passwords and sensitive data  
- 🚪 Implement logout functionality  
- 🔑 Implement API key system including validation of API users

---

## 🌀 TO BE CONTINUED...
