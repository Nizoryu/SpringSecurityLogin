package fr.formation.inti.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.entity.Employee;

@Service("serviceEmployee")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDaoImpl dao;

	public EmployeeServiceImpl() {
//		dao = new EmployeeDaoImpl();
		System.out.println("Instance of EmployeeServiceImpl");
	}

	public EmployeeDaoImpl getDao() {
		return dao;
	}

	public void setDao(EmployeeDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public Employee findById(Integer id) {
//		dao.beginTransaction();
		Employee e = dao.findById(id);
//		dao.commit(true);
		return e;
	}

	@Override
	public List<Employee> findAll() {
//		dao.beginTransaction();
		List<Employee> list = dao.findAll();
//		dao.commit(true);
		return list;
	}

	@Override
	public Integer save(Employee e) {
//		dao.beginTransaction();
		Employee cust = dao.save(e);
//		dao.commit(true);
		return cust.getEmpId();
	}

	@Override
	public void delete(Employee entiy) {
//		dao.beginTransaction();
		dao.delete(entiy);
//		dao.commit(true);

	}

	@Override
	public void deleteById(Integer id) {
//		dao.beginTransaction();
		dao.deleteById(id);
//		dao.commit(true);

	}

}
