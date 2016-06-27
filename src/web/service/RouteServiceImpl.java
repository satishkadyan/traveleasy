package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.bean.Route;
import web.dao.RouteDAO;

@Service
public class RouteServiceImpl implements RouteService {

	public RouteDAO routeDAO;

	public void setRouteDAO(RouteDAO routeDAO) {
		this.routeDAO = routeDAO;
	}

	@Override
	@Transactional
	public Route addRoute(Route route) {
		Route routeFetch;
		routeFetch = this.routeDAO.addRoute(route);
		return routeFetch;
	}

}
