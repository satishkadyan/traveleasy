package web.httpresult;

import web.bean.User;

public class UserResult {

	User user;
	int status;
	public static final int EXIST = 1, CREATED = 0, FAIL = -1;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserResult(User user, int status) {
		this.user = user;
		this.status = status;
	}
}
