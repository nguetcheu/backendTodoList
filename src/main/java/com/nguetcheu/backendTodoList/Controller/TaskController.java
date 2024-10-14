package com.nguetcheu.backendTodoList.Controller;

import com.nguetcheu.backendTodoList.Entity.Task;
import com.nguetcheu.backendTodoList.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/task")
@RestController
@CrossOrigin("*")
public class TaskController {

    public TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTasById(@PathVariable("taskId") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        taskService.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable("taskId") Long taskId, @RequestBody Task task){
        taskService.updateTask(taskId, task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return "task with id " + taskId + " deleted";
    }
}
