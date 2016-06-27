package web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import core.exception.UserNotExistException;
import web.bean.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public User addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		return u;
	}

	@Override
	public User findUser(User u) throws UserNotExistException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", u.getEmail()));
		User user = (User) criteria.uniqueResult();
		if (user == null) {
			throw new UserNotExistException();
		}
		return user;
	}

}
