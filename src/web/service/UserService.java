package web.service;

import web.bean.User;
import web.httpresult.UserResult;

public interface UserService {
	public UserResult authenticationUser(User user);
}
