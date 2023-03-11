package com.miniprojet.employees.repository;

import com.miniprojet.employees.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employees, Integer> {
}
