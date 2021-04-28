package com.projects.github.hibernate.repository;

import com.projects.github.hibernate.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
}
