package com.nguetcheu.backendTodoList.Service;

import com.nguetcheu.backendTodoList.Entity.Task;
import com.nguetcheu.backendTodoList.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = taskRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Task not found"));
       taskToUpdate.setTitle(task.getTitle());
       taskToUpdate.setDescription(task.getDescription());
       taskToUpdate.setCompleted(task.isCompleted());
        return taskToUpdate;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(Math.toIntExact(id));
    }
}
