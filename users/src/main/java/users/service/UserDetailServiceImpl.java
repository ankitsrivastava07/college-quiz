package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import users.dao.UserDao;
import users.dao.entity.UserEntity;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		username.toLowerCase();
		/*
		 * UserEntity entity=userDao.findByUserName(username) User user= new
		 * User(entity.getUserName(),entity.getPassword(),new ArrayList<>());
		 */
		//MutableUser m = new MutableUser();
		
		/*
		 * UserEntity entity= new UserEntity(); entity.setUserName("ankit");
		 * entity.setPassword("2");
		 */		User user=null ;
		return user;
	}

}
