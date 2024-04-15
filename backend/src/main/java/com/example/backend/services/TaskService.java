package com.example.backend.services;

import com.example.backend.entities.DummyTask;
import com.example.backend.entities.Task;
import com.example.backend.enums.TaskStatus;
import com.example.backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(DummyTask dtask) {
        Task task = new Task();
        task.setTaskName(dtask.getTaskName());
        task.setTaskDescription(dtask.getTaskDescription());
        task.setTaskStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDate.now());
        return taskRepository.save(task);
    }

    public Task updateTask(int tid , DummyTask dtask) {
        Task t = getTaskById(tid);
        t.setTaskName(dtask.getTaskName());
        t.setTaskDescription(dtask.getTaskDescription());
        return taskRepository.save(t);
    }

    public Task markComplete(Integer id) {
        Task t = getTaskById(id);
        t.setTaskStatus(TaskStatus.COMPLETED);
        return taskRepository.save(t);
    }

    public Task markDelete(Integer id) {
        Task t = getTaskById(id);
        t.setTaskStatus(TaskStatus.DELETED);
        return taskRepository.save(t);
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }
}
