package com.cledilsondevcode.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITasckRepository tasckRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel){
        System.out.println("Chegou no controller");
        TaskModel tack = this.tasckRepository.save(taskModel);

        return tack;

    }

}
