package users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import users.dao.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String findByUserName(String userName) {
		return userRepository.findByUserNameOrEmail(userName);
	}

}
