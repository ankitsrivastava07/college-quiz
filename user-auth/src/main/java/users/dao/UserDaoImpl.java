package users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import users.dao.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String findByUserNameAndPassword(String username, String password) {

		return userRepository.findByUserNameAndPassword(username.toLowerCase(), password);
	}

	@Override
	public Boolean isUserBlocked(String username) {
		Boolean flag = userRepository.isUserBlocked(username);

		return userRepository.isUserBlocked(username.toLowerCase());
	}

	@Override
	public String findByUserName(String username) {

		return userRepository.findByUserNameOrEmail(username);

	}

}
