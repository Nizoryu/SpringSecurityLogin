package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entity.User;

@Service("serviceUser")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDaoImpl dao;

	public UserServiceImpl() {
		System.out.println("Instance of UserServiceImpl");
	}

	public UserDaoImpl getDao() {
		return dao;
	}

	public void setDao(UserDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public User findById(Integer id) {
		User e = dao.findById(id);
		return e;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> findAll() {
		List<User> list = dao.findAll();
		return list;
	}

	@Override
	public Integer save(User e) {
//		dao.beginTransaction();
		User cust = dao.save(e);
//		dao.commit(true);
		return cust.getIdUser ();
	}

	@Override
	public void delete(User entiy) {
//		dao.beginTransaction();
		dao.delete(entiy);
//		dao.commit(true);

	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);

	}
	@Override

	public User findByUniqueEmail(String email) {	
		return dao.findByUniqueEmail(email);
	}
}
