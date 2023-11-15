package com.cledilsondevcode.todolist.repository;

import com.cledilsondevcode.todolist.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT e FROM tab_userModel e JOIN FETCH e.roles WHERE e.username= (:username)")
    public UserModel findByUsername(@Param("username") String username);

//    @Query(value = "SELECT * FROM tb_user u JOIN tab_user_roles r ON u.id_user = r.user_id WHERE u.username = :username", nativeQuery = true)
//    public UserModel findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);

}
