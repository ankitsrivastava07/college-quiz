package users.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import users.dao.UserDao;
import users.exceptionHandle.UserBlockedException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void isUserBlocked(String username) {

		if (userDao.isUserBlocked(username))
			throw new UserBlockedException("Your account has been blocked for 24 hours");
	}

	@Override
	public String findByUserNameAndPassword(String username, String password) {
		isUserBlocked(username);
		return userDao.findByUserNameAndPassword(username, password);
	}

	@Override
	public String findByUserName(String username) {

		if (Objects.isNull(userDao.findByUserName(username)))
			throw new UsernameNotFoundException("Username not found");
		return username;
	}

}
