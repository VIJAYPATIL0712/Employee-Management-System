package com.vijay.emp_management.service;

import com.vijay.emp_management.entity.Employe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeService {

     Employe saveEmploye(Employe employe) ;



    List<Employe> getAllEmploye();

    void deleteEmploye(Long id);

    Employe getEmployeById(Long id);

    List<Employe> searchEmploye(String keyword);

    Page<Employe> getAllEmployePaginated(int pageNo);
}
