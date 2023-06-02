package co.grandcircus.taskmanager.service;

import co.grandcircus.taskmanager.model.Task;

import java.util.List;

public interface TaskService {

    void createTask(Task task);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);

    List<Task> findAll();

    void setTaskCompleted(Long id);

    void setTaskNotCompleted(Long id);

    Task getTaskById(Long taskId);

}
