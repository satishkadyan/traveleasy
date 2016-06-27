package web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import core.exception.RouteNotExistException;
import web.bean.Route;

@Repository
public class RouteDAOImpl implements RouteDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Route addRoute(Route route) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(route);
		return route;
	}

	@Override
	public Route findRoute(Route route) throws RouteNotExistException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Route.class).add(Restrictions.eq("id", route.getId()));
		Route routeret = (Route) criteria.uniqueResult();
		if (routeret == null) {
			throw new RouteNotExistException();
		}
		return routeret;
	}

}


