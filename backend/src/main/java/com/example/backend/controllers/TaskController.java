package com.example.backend.controllers;

import com.example.backend.entities.DtoTask;
import com.example.backend.entities.DummyTask;
import com.example.backend.entities.Task;
import com.example.backend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<DtoTask> getAllTasks(){
        List<Task> task = taskService.getAllTasks();
        List<DtoTask> tasks = new ArrayList<>();
        for (int i = 0; i < task.size(); i++) {
            tasks.add(new DtoTask(task.get(i)));
        }
        return tasks;
    }

    @PostMapping
    public DtoTask saveTask(@RequestBody DummyTask dtask){
        Task task = taskService.saveTask(dtask);
        return new DtoTask(task);
    }

    @PutMapping("/{tid}")
    public DtoTask updateTask(@RequestBody DummyTask dtask, @PathVariable("tid") int tid){
        Task task = taskService.updateTask(tid, dtask);
        return new DtoTask(task);
    }

    @PutMapping("/{tid}/markComplete")
    public DtoTask markComplete(@PathVariable("tid") int tid){
        Task task = taskService.markComplete(tid);
        return new DtoTask(task);
    }

    @PutMapping("/{tid}/markDelete")
    public DtoTask markDelete(@PathVariable("tid") int tid){
        Task task = taskService.markDelete(tid);
        return new DtoTask(task);
    }

}
