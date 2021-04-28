package com.projects.github.hibernate.repository;

import com.projects.github.hibernate.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
