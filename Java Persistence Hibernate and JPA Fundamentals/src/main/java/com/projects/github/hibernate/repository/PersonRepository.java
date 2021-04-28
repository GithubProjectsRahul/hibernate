package com.projects.github.hibernate.repository;

import com.projects.github.hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
