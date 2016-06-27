package web.dao;

import core.exception.UserNotExistException;
import web.bean.User;

public interface UserDAO {

	public User addUser(User user);

	public User findUser(User user) throws UserNotExistException;
}
