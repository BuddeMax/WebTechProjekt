package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
