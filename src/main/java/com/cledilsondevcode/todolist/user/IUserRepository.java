package com.cledilsondevcode.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {

        UserModel findByUsername(String username);

}
