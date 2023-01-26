package fr.formation.inti.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
	public UserDaoImpl() {
		super(User.class);
		System.out.println("instance of UserDaoImpl");
	}

	@Override
	public User findByUniqueEmail(String email) {
		User user = null;
		String hql = "FROM User where email =:email";
		Query query = getSession().createQuery(hql).setParameter("email", email);
		user = (User) query.uniqueResult();
		return user;
	}

}
