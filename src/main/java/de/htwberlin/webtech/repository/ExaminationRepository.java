package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Examination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends CrudRepository<Examination, Long> {
}

