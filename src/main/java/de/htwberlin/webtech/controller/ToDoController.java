package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ToDoController {

    @Autowired
    ToDoService service;

    Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @PostMapping("/todo")
    public ToDo createToDo(@RequestBody ToDo todo) {
        return service.save(todo);
    }

    @GetMapping("/todo/{id}")
    public ToDo getToDo(@PathVariable String id) {
        logger.info("GET request on route todo with {}", id);
        Long todoId = Long.parseLong(id);
        return service.get(todoId);
    }

    @GetMapping("/todos")
    public List<ToDo> getAllToDos() {
        return service.getAll();
    }

    @DeleteMapping("/todo/{id}")
    public void deleteToDo(@PathVariable String id) {
        logger.info("DELETE request on route todo with {}", id);
        Long todoId = Long.parseLong(id);
        service.delete(todoId);
    }

    // Neue Methode für die Aktualisierung einer Aufgabe
    @PutMapping("/todo/{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDo updatedToDo) {
        logger.info("PUT request on route todo with {}", id);
        Long todoId = Long.parseLong(id);
        return service.update(todoId, updatedToDo);
    }
}

