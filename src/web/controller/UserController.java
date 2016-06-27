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

import web.bean.User;
import web.httpresult.UserResult;
import web.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public ResponseEntity<User> authenticateUser(RequestEntity<User> requestEntity) {
		User user = (User) requestEntity.getBody();
		UserResult userret = this.userService.authenticationUser(user);
		HttpHeaders headers = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.OK;
		if (userret.getStatus() == UserResult.EXIST) {
			httpStatus = HttpStatus.OK;
		} else if (userret.getStatus() == UserResult.CREATED) {
			httpStatus = HttpStatus.CREATED;

		}
		ResponseEntity<User> re = new ResponseEntity<User>(userret.getUser(), headers, httpStatus);

		return re;
	}
}