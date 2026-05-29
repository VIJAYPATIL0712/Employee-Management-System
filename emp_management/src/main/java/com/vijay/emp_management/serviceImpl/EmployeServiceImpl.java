package com.vijay.emp_management.serviceImpl;

import com.vijay.emp_management.entity.Employe;
import com.vijay.emp_management.repository.EmployeRepository;
import com.vijay.emp_management.service.EmployeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }


    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe getEmployeById(Long id) {

        return employeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Employe Not Found"));

    }

    @Override
    public List<Employe> searchEmploye(String keyword) {
        return employeRepository.findByNameContainingIgnoreCase(keyword);

    }

    @Override
    public Page<Employe> getAllEmployePaginated(int pageNo) {

        int pageSize = 5;

        Pageable pageable =
                PageRequest.of(pageNo - 1, pageSize);

        return employeRepository.findAll(pageable);
    }
}
