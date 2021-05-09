package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lin.entity.User;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public  interface  UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);

    @Query(value = "select  * from user u where u.email = ?1 and u.flash = 1 " , nativeQuery = true)
    User findByEmailAdmin(String email);

    Integer deleteUserByEmail(String email);
}
