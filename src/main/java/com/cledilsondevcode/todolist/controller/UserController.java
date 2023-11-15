package com.cledilsondevcode.todolist.controller;

import com.cledilsondevcode.todolist.handler.BusinessException;
import com.cledilsondevcode.todolist.handler.CampoObrigatorioException;
import com.cledilsondevcode.todolist.model.UserModel;
import com.cledilsondevcode.todolist.repository.UserRepository;
import com.cledilsondevcode.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void postUser(@RequestBody UserModel user){
        userService.createUser(user);
    }


//    @PostMapping("/createUser")
//    public ResponseEntity create(@RequestBody UserModel userModel) {
//        UserModel user = this.userRepository.findByUsername(userModel.getUsername());
//        if (user != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!!");
//        }
//
//        // Se o usuário não existir, faça o que for necessário aqui, por exemplo, salvar o usuário.
//
////        String passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
//
//        userModel.setPassword(userModel.getPassword());
//
//        if (userModel.getPassword() == null) {
//            throw new CampoObrigatorioException("password");
//        } else if (userModel.getUsername() == null) {
//            throw new CampoObrigatorioException("login");
//        } else {
//
//            UserModel userCreated = this.userRepository.save(userModel);
//            return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
//        }
//
//
//
//    }
//
//    @GetMapping("/listUsers")
//    public List<UserModel> list(){
//        List<UserModel> users = this.userService.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(users).getBody();
//    }
//
//    @GetMapping("/managers/{username}")
//    public UserModel getUser(@PathVariable("username") String username){
//        UserModel userModel = userService.
//        return ResponseEntity.status(HttpStatus.OK).body(userModel).getBody();
//    }
//
//    @DeleteMapping("/managers/{id}")
//    public Long deleteUser(@PathVariable("id") Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(id).getBody();
//    }



}
