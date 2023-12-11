package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.AbstractUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractUserRepository extends CrudRepository<AbstractUser,Long> {
}
