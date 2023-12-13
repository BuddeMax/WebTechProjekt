package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
