package com.cledilsondevcode.todolist.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITasckRepository extends JpaRepository<TaskModel, Long> {



}
