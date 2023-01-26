package fr.formation.inti.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	private Session session;

	private Class<T> type;

	public GenericDaoImpl() {

	}

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public T findById(ID id) {
		return getSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createQuery("select t from " + type.getName() + " t").getResultList();
	}

	@Override
	public T save(T entiy) {
		getSession().saveOrUpdate(entiy);
		return entiy;
	}

	@Override
	public void delete(T entiy) {
		getSession().delete(entiy);

	}

	@Override
	public void deleteById(ID id) {
		T t = getSession().get(type, id);
		getSession().delete(t);

	}

}
