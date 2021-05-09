package users.service;

public interface UserService {

	String findByUserNameAndPassword(String username, String password);
	
	void isUserBlocked(String username);

}
