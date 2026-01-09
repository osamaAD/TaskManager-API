package com.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

  @NotBlank
  @Size(max = 120)
  private String title;

  @Size(max = 500)
  private String description;

  private Boolean completed;

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public Boolean getCompleted() { return completed; }
  public void setCompleted(Boolean completed) { this.completed = completed; }
}
