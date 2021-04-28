package com.projects.github.hibernate.repository;

import com.projects.github.hibernate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
