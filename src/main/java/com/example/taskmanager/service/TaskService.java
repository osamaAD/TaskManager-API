package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

  private final TaskRepository repository;

  public TaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public Task create(TaskRequest request) {
    Task task = new Task(request.getTitle(), request.getDescription());
    if (request.getCompleted() != null) task.setCompleted(request.getCompleted());
    return repository.save(task);
  }

  public List<Task> list() {
    return repository.findAll();
  }

  public Task get(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
  }

  public Task update(Long id, TaskRequest request) {
    Task task = get(id);
    task.setTitle(request.getTitle());
    task.setDescription(request.getDescription());
    if (request.getCompleted() != null) task.setCompleted(request.getCompleted());
    return repository.save(task);
  }

  public void delete(Long id) {
    Task task = get(id);
    repository.delete(task);
  }
}
