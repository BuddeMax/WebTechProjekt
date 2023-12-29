package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.service.PatientService;
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
    ToDoService toDoService;

    @Autowired
    PatientService patientService;

    Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @PostMapping("/todo")
    public ToDo createToDo(@RequestBody ToDo todo) {
        return toDoService.save(todo);
    }

    @GetMapping("/todo/{id}")
    public ToDo getToDo(@PathVariable String id) {
        logger.info("GET request on route todo with {}", id);
        Long todoId = Long.parseLong(id);
        return toDoService.get(todoId);
    }

    @GetMapping("/todos")
    public List<ToDo> getAllToDos() {
        return toDoService.getAll();
    }

    @DeleteMapping("/todo/{id}")
    public void deleteToDo(@PathVariable String id) {
        logger.info("DELETE request on route todo with {}", id);
        Long todoId = Long.parseLong(id);
        toDoService.delete(todoId);
    }

    // Neue Methode für die Aktualisierung einer Aufgabe
    @PutMapping("/todo/{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDo updatedToDo) {
        logger.info("PUT request on route todo with {}", id);
        Long todoId = Long.parseLong(id);
        return toDoService.update(todoId, updatedToDo);
    }

    // Put an existing ToDo to an existing Patient
    @PutMapping("/todo/{todoId}/patient/{patientId}")
    public ToDo assignTodoToPatient(@PathVariable Long todoId, @PathVariable Long patientId) {
        ToDo toDo = toDoService.get(todoId);
        Patient patient = patientService.get(patientId);
        toDo.assignPatient(patient);
        return toDoService.save(toDo);
    }

    //Delete a Todo from a patient
    @DeleteMapping("/todo/{todoId}/patient/{patientId}")
    public void deleteToDoFromPatient(@PathVariable Long todoId, @PathVariable Long patientId) {
        ToDo todo = toDoService.get(todoId);
        Patient patient = patientService.get(patientId);
        todo.assignPatient(null);
        toDoService.save(todo);
    }

    // Get all Todos from a patient
    @GetMapping("/patient/{patientId}/todos")
    public Iterable<ToDo> getAllToDosFromPatient(@PathVariable Long patientId) {
        Patient patient = patientService.get(patientId);
        return patient.getToDos();
    }
}

