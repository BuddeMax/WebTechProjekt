package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Physician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends CrudRepository<Physician, Long> {
}

