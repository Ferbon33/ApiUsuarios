package com.api.Usuarios.repository;


import com.api.Usuarios.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

/*/
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Query(value="SELECT * FROM user" , nativeQuery = true)
    List<UserModel> findAll();

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Query(value="INSERT INTO user (first_name,last_name) VALUES (:user.getFirtsName,:user.getFirtsName)", nativeQuery = true)
    UserModel save(UserModel user);
    /*/
@Transactional
@Query(value="SELECT count(*) FROM user WHERE email=:email", nativeQuery = true)
int checkMail( @Param("email") String email);
}
