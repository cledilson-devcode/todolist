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


//    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
//
//        Object idUser = request.getAttribute("idUser");
//        taskModel.setIdUser((Long) idUser);
//
//        LocalDateTime currentDate = LocalDateTime.now();
//        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início e termino devem ser maiores do que a data atual");
//        }
//        if (taskModel.getStartAt().isAfter(taskModel.getEndAt()) ){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser menor do que a data de termino");
//        }
//
//        TaskModel tack = this.tasckRepository.save(taskModel);
//
//        return ResponseEntity.status(HttpStatus.OK).body(tack);
//
//    }

    @GetMapping("/listTask")
    public List<TaskModel> list(){
        List<TaskModel> tasks = this.tasckRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks).getBody();
    }

//    @GetMapping("/listarProdutos")
//    public List<TaskModel> list(HttpServletRequest request){
//        Object idUser = request.getAttribute("idUser");
//        List<TaskModel> tasks = this.tasckRepository.findByIdUser((Long) idUser);
//        return tasks;
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable Long id){
//
//        Object idUser = request.getAttribute("idUser");
//
//        TaskModel task = this.tasckRepository.findById(id).orElse(null);
//
//        if (task == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa não encontrada");
//
//        }
//
//        if (!task.getIdUser().equals(idUser)){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não tem permissão para alterar essa tarefa");
//        }else {
//            if (!tasckRepository.findById(id).isEmpty()) {
//
//
//                Utils.copyNonNullProperties(taskModel, task);
//
//                TaskModel tack = this.tasckRepository.save(task);
//
//                return ResponseEntity.status(HttpStatus.OK).body(tack);
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Informe uma tarefa existente");
//            }
//        }
//
//    }


}
