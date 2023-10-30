package com.cledilsondevcode.todolist.repository;

import com.cledilsondevcode.todolist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

        UserModel findByUsername(String username);

}
