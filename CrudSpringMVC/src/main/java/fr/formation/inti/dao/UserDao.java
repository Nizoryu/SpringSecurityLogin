package fr.formation.inti.dao;

import fr.formation.inti.entity.User;

public interface UserDao extends GenericDao<User, Integer> {
	
	public User findByUniqueEmail(String email);
}
