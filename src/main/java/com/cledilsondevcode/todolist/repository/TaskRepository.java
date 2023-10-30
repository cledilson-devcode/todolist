package com.cledilsondevcode.todolist.repository;

import com.cledilsondevcode.todolist.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

        List<TaskModel> findByIdUser(Long idUser);
        TaskModel findByIdAndIdUser(Long id, Long idUser);
}
