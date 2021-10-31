package com.poc2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
//@Modifying
//@Query(value = "update user u set u.name=?1, u.dob=?2, u.joinDate=?3, u.location=?4  where u.id=:id")
//User updateUserById(String name, Date dob, Date joinDate, String loc, int id);

  @Query(value = "SELECT * from user u where u.name=:name", nativeQuery = true)
 //@Query(value = "SELECT u from user u where u.name=?1")
  List<User> findByName(String name);
	
  @Query(value = "select * from user order by joining_date desc, name desc", nativeQuery = true)
  List<User> sortUsers();
  
  @Transactional
  @Modifying
  @Query(value = "update user u set u.deleted = 1 where u.id =:id", nativeQuery = true)
  void softDel(int id);
}
