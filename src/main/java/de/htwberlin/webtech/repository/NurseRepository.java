package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Nurse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Long>{}
