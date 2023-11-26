package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.VitalSigns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignsRepository extends CrudRepository<VitalSigns, Long> {
}

