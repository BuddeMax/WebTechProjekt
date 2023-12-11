package de.htwberlin.webtech.service;

import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    public ToDo save(ToDo todo) {
        return repo.save(todo);
    }

    public ToDo get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
    }

    public List<ToDo> getAll() {
        Iterable<ToDo> iterator = repo.findAll();
        List<ToDo> todos = new ArrayList<>();
        iterator.forEach(todos::add);
        return todos;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Neue Methode für die Aktualisierung einer Aufgabe
    public ToDo update(Long id, ToDo updatedToDo) {
        ToDo existingToDo = repo.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));

        // Setze die aktualisierten Werte
        existingToDo.setBeschreibung(updatedToDo.getBeschreibung());
        existingToDo.setPrioritaet(updatedToDo.getPrioritaet());
        existingToDo.setStatus(updatedToDo.getStatus());
        existingToDo.setRecordingTime(updatedToDo.getRecordingTime());

        // Speichere die Aktualisierung in der Datenbank
        return repo.save(existingToDo);
    }
}

