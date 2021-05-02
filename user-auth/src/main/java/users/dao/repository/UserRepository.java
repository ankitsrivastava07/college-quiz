package users.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import users.dao.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value="select * from login where user_name =?1 or email=?1",nativeQuery=true)
	String findByUserNameOrEmail(String email);

}
