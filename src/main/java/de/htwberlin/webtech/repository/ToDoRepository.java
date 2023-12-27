package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
