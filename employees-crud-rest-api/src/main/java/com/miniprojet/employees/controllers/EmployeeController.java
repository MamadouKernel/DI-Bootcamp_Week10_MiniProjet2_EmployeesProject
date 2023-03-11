package com.miniprojet.employees.controllers;

import com.miniprojet.employees.dao.IDao;
import com.miniprojet.employees.exceptions.ResourceNotFoundException;
import com.miniprojet.employees.models.Employees;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private IDao<Employees> employeeIDao;

    @GetMapping()
    public ResponseEntity<List<Employees>> findAll() {
        try {
            return ResponseEntity.ok(employeeIDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((List<Employees>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> findById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(employeeIDao.findById(id));
    }

    @PostMapping()
    public ResponseEntity<String> create(@Valid @RequestBody Employees employees) {
        Map<String, String> response = new HashMap<>();
        try {
            Employees employeesCreated = employeeIDao.create(employees);
            response.put("message", "Employé créé avec succès");
            response.put("data", employeesCreated.toString());
            return new ResponseEntity<>(response.toString(), HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Erreur survenue lors de la création de l'employée");
            return new ResponseEntity<>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<String> update(@Valid @RequestBody Employees employees) {
        Map<String, String> response = new HashMap<>();
        try {
            Employees employeesUpdated = employeeIDao.create(employees);
            response.put("message", "Employé modifié avec succès");
            response.put("data", employeesUpdated.toString());
            return new ResponseEntity<>(response.toString(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Erreur survenue lors de la modification de l'employée");
            return new ResponseEntity<>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Valid @PathVariable int id) {
        Map<String, String> response = new HashMap<>();
        try {
            employeeIDao.delete(id);
            response.put("message", "Employé supprimé avec succès");
            return new ResponseEntity<>(response.toString(), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            response.put("message", "Erreur survenue lors de la suppression de l'employée");
            return new ResponseEntity<>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
