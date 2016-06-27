package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.bean.Route;
import web.service.RouteService;

@RestController
public class RouteController {

	private RouteService routeService;

	@Autowired(required = true)
	@Qualifier(value = "routeService")
	public void setRouteService(RouteService rs) {
		this.routeService = rs;
	}

	@RequestMapping(value = "/route", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public ResponseEntity<Route> authenticateUser(RequestEntity<Route> requestEntity) {
		Route route = (Route) requestEntity.getBody();
		Route routeret = this.routeService.addRoute(route);
		HttpHeaders headers = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.OK;
		if (routeret != null) {
			httpStatus = HttpStatus.OK;
		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Route> re = new ResponseEntity<Route>(routeret, headers, httpStatus);

		return re;
	}
}