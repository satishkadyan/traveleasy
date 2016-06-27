package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.exception.UserNotExistException;
import web.bean.User;
import web.dao.UserDAO;
import web.httpresult.UserResult;

@Service
public class UserServiceImpl implements UserService {

	public UserDAO userDAO;

	public void setUserDAO(UserDAO personDAO) {
		this.userDAO = personDAO;
	}

	@Override
	@Transactional
	public UserResult authenticationUser(User user) {
		User userFetch;
		UserResult ur = null;
		try {
			userFetch = this.userDAO.findUser(user);
			ur = new UserResult(userFetch, UserResult.EXIST);
			return ur;
		} catch (UserNotExistException e) {
			userFetch = this.userDAO.addUser(user);
			ur = new UserResult(userFetch, UserResult.CREATED);
			e.printStackTrace();
		}
		return ur;
	}

}
