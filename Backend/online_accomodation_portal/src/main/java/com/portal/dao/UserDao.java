package com.portal.dao;

<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/dao/UserDao.java
import java.util.Optional;
=======
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/dao/UserDao.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Users;
<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/dao/UserDao.java

public interface UserDao extends JpaRepository<Users, Long> {

	Optional<Users> findByEmailAndPassword(String email, String password);

	Users findByEmail(String email);
=======
public interface UserDao extends JpaRepository<Users, Long> {

	
	public Users findByEmail(String email);

>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/dao/UserDao.java
}
