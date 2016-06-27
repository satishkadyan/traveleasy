package web.dao;

import core.exception.RouteNotExistException;
import web.bean.Route;

public interface RouteDAO {

	public Route addRoute(Route route);

	public Route findRoute(Route route) throws RouteNotExistException;
}
