package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.Employee;

public interface EmployeeService {

	Employee findById(Integer id);

	List<Employee> findAll();

	Integer save(Employee c);

	void delete(Employee entiy);

	void deleteById(Integer id);

	 
}
