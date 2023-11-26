package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Bed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends CrudRepository<Bed, Long> {
}

