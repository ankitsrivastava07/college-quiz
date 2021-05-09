
package users.service;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;

import users.dao.UserDao;
import users.exceptionHandle.InvalidCredentialException;
import users.exceptionHandle.UserBlockedException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void isUserBlocked(String username) {
		Boolean isBlocked = userDao.isUserBlocked(username);

		if (Objects.nonNull(isBlocked) && isBlocked != false)
			throw new UserBlockedException("Your account has been blocked for 24 hours");
	}

	@Override
	public String findByUserNameAndPassword(String username, String password) {

		isUserBlocked(username);
		username = userDao.findByUserNameAndPassword(username, password);

		if (Objects.isNull(username)) {
			throw new InvalidCredentialException(
					"Invalid username/email or password which you have provided");
		}

		return username;
	}

	/**
	 * @Override public String findByUserName(String username) {
	 * 
	 *           if (Objects.isNull(userDao.findByUserName(username))) throw new
	 *           UsernameNotFoundException("Username not found"); return username; }
	 */
}
