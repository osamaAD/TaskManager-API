# TaskManager API

A simple REST API to manage tasks (create, list, update, delete).
This project is designed for practicing GitHub + Docker basics.

## Features
- CRUD operations for tasks
- H2 in-memory database (no setup needed)
- Swagger UI for testing endpoints

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Web, Spring Data JPA
- H2 Database
- Maven
- Docker (multi-stage build)

## Run Locally

### Requirements
- Java 17
- Maven

### Steps
```bash
mvn spring-boot:run
```

API base URL:
- http://localhost:8080/api/tasks

Swagger UI:
- http://localhost:8080/swagger

H2 Console:
- http://localhost:8080/h2-console
JDBC URL: `jdbc:h2:mem:tasksdb`
User: `sa`  Password: (empty)

## API Endpoints

### Create task
POST `/api/tasks`
```json
{
  "title": "Study Spring Boot",
  "description": "Build a small REST API",
  "completed": false
}
```

### List tasks
GET `/api/tasks`

### Get task by id
GET `/api/tasks/{id}`

### Update task
PUT `/api/tasks/{id}`
```json
{
  "title": "Study Docker",
  "description": "Dockerize the app",
  "completed": true
}
```

### Delete task
DELETE `/api/tasks/{id}`

## Run with Docker

### Build image
```bash
docker build -t task-manager-api .
```

### Run container
```bash
docker run -p 8080:8080 task-manager-api
```

Then open:
- http://localhost:8080/swagger

## Run with Docker Compose (optional)
```bash
docker compose up --build
```

## Expected Output
- The service starts on port 8080
- `GET /api/tasks` returns a list of tasks (seeded tasks included)

## References
- Spring Boot documentation
- Docker documentation
