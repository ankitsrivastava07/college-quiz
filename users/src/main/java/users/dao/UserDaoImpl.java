package users.dao;

import org.springframework.stereotype.Repository;

import lombok.Data;
import users.dao.repository.UserRepository;

@Repository
@Data
public class UserDaoImpl implements UserDao {

	private UserRepository userRepository;

	@Override
	public String findByUserName(String userName) {
		return userRepository.findByUserNameOrEmail(userName);
	}

}
