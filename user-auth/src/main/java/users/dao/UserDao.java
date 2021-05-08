package users.dao;

public interface UserDao {

	String findByUserNameAndPassword(String username, String password);

	Boolean isUserBlocked(String username);

	String findByUserName(String username);
}
