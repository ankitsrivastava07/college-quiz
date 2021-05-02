package users.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.dao.UserDao;
import users.exceptionHandle.UserNameNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String findByUserName(String username) {
		username = userDao.findByUserName(username.toLowerCase());

		if (Objects.isNull(username))
			throw new UserNameNotFoundException("Username which you have provided does not exist");

		return username;
	}

}
