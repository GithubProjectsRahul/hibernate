package com.projects.github.hibernate.repository;

import com.projects.github.hibernate.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
