package com.example.backend.entities;

import com.example.backend.enums.TaskStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoTask {
    private Integer taskId;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    private LocalDate createdAt;

    public DtoTask(Task task) {
        this.taskId = task.getTaskId();
        this.taskName = task.getTaskName();
        this.taskDescription = task.getTaskDescription();
        this.taskStatus = task.getTaskStatus();
        this.createdAt = task.getCreatedAt();
    }

}
