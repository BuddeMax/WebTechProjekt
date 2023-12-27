package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractUserRepository extends JpaRepository<AbstractUser,Long> {
}
