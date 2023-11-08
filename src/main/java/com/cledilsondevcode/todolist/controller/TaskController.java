package com.cledilsondevcode.todolist.controller;

import com.cledilsondevcode.todolist.model.TaskModel;
import com.cledilsondevcode.todolist.repository.TaskRepository;
//import com.cledilsondevcode.todolist.utils.Utils;
//import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository tasckRepository;

    @PostMapping("/createTask")
    public ResponseEntity create(@RequestBody TaskModel taskModel){


        LocalDateTime currentDate = LocalDateTime.now();
        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início e termino devem ser maiores do que a data atual");
        }
        if (taskModel.getStartAt().isAfter(taskModel.getEndAt()) ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser menor do que a data de termino");
        }

        TaskModel task = this.tasckRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);

    }




    @GetMapping("/listTask")
    public List<TaskModel> list(){
        List<TaskModel> tasks = this.tasckRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks).getBody();
    }




}
