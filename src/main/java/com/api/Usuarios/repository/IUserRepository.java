package com.api.Usuarios.repository;


import com.api.Usuarios.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {


    @Transactional
    @Query(value="SELECT count(*) FROM user WHERE email=:email", nativeQuery = true)
    int checkMail( @Param("email") String email);

    @Modifying
    @Transactional
    @Query(value="UPDATE user  SET name=:name, email=:email, password=:password, modified=:modified  WHERE id = :id", nativeQuery = true)
    int UpdateUser( @Param("name") String name,@Param("email") String email,@Param("password") String password, @Param("id") Long id,@Param("modified") LocalDateTime modified);


}
