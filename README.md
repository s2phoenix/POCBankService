# Bank Service Demo (Monolith Concept)

This project is a demo of a **bank service** using a **monolithic architecture**.  
All code is consolidated into this project as the core system to test some code design concepts.

---

## Instructions

1. Setup Kafka or Redis  
2. Setup Flyway  
3. Check configuration files  
4. don't for got docker compose up/down.
5. Run the application

---

## Current Status

- **Auth Service** and **User Service** are combined in this project.  
  Separation into microservices will be decided later.  
- **Transfer Service** implements a simple concept.  
- **`OpenApi`** Generates models and TypeScript REST templates for Angular. just run mvn build.
- **`Role-based authorization`** is implemented. @try   
- **`JWT`** (JSON Web Token) is used for authentication.  
- Batch schedule service.  
- Workflow engine: this concept allows implementing many services just by configuration. It looks like a state machine but is custom created.  
- Simple REST calls using **`Java Reactive`** concept to payment service.
- **`Flyway DB Migation`**

---

## Next Features to Implement

- Encrypt passwords and sensitive data  
- Implement logout functionality  
- Implement API key system including validation of API users

---

## TO BE CONTINUED...
