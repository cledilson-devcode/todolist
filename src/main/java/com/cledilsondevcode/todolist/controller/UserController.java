package com.cledilsondevcode.todolist.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.cledilsondevcode.todolist.model.TaskModel;
import com.cledilsondevcode.todolist.model.UserModel;
import com.cledilsondevcode.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/createUser")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        UserModel user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!!");
        }

        // Se o usuário não existir, faça o que for necessário aqui, por exemplo, salvar o usuário.

//        String passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(userModel.getPassword());

        UserModel userCreated = this.userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/listUsers")
    public List<UserModel> list(){
        List<UserModel> users = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users).getBody();
    }



}
