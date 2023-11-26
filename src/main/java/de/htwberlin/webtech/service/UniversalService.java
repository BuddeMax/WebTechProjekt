package de.htwberlin.webtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversalService {

    @Autowired
    private ApplicationContext applicationContext;

    public Object create(String entityName, Object entity) {
        CrudRepository repository = getRepository(entityName);
        return repository.save(entity);
    }

    public Object get(String entityName, Long id) {
        CrudRepository repository = getRepository(entityName);
        try {
            return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<?> getAll(String entityName) {
        CrudRepository repository = getRepository(entityName);
        return repository.findAll();
    }

    public Object update(String entityName, Long id, Object entityDetails) {
        CrudRepository repository = getRepository(entityName);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entity not found");
        }
        return repository.save(entityDetails);
    }

    public void delete(String entityName, Long id) {
        CrudRepository repository = getRepository(entityName);
        repository.deleteById(id);
    }

    private CrudRepository getRepository(String entityName) {
        String repositoryName = entityName.substring(0, 1).toLowerCase() + entityName.substring(1) + "Repository";
        return (CrudRepository) applicationContext.getBean(repositoryName);
    }
}

