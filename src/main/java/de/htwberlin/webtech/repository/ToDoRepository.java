package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Physician;
import de.htwberlin.webtech.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface ToDoRepository extends CrudRepository<ToDo, Long>{
}
