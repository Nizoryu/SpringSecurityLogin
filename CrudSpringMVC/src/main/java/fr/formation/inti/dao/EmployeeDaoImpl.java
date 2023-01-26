package fr.formation.inti.dao;

import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.Employee;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer> implements EmployeeDao {
	public EmployeeDaoImpl() {
		super(Employee.class);
		System.out.println("instance of EmployeeDaoImpl");
	}

}
