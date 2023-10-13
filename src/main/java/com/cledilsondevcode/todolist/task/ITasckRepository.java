package com.cledilsondevcode.todolist.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITasckRepository extends JpaRepository<TaskModel, Long> {

        List<TaskModel> findByIdUser(Long idUser);
        TaskModel findByIdAndIdUser(Long id, Long idUser);
}
