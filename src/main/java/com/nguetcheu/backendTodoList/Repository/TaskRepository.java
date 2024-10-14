package com.nguetcheu.backendTodoList.Repository;

import com.nguetcheu.backendTodoList.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
