package com.miniprojet.employees.dao;

import com.miniprojet.employees.exceptions.ResourceNotFoundException;
import com.miniprojet.employees.models.Employees;
import com.miniprojet.employees.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeIDaoImpl implements IDao<Employees> {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees findById(int id) throws ResourceNotFoundException {
        Optional<Employees> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("User not found with id : " + id);
        }
    }

    @Override
    public Employees create(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public Employees update(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public void delete(Employees employees) {
        employeeRepository.delete(employees);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
