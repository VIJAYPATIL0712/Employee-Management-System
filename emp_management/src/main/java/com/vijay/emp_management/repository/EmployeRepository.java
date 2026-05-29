package com.vijay.emp_management.repository;


import com.vijay.emp_management.entity.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe , Long> {

    List<Employe> findByNameContainingIgnoreCase(String name);

    Page<Employe> findAll(Pageable pageable);
}
