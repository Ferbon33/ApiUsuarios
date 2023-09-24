package com.api.Usuarios.repository;

import com.api.Usuarios.models.PhoneModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface IPhonesRepository extends JpaRepository<PhoneModel, Long> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO phones (uuid,number,citycode,contrycode) VALUES (:uuid,:number,:citycode,:contrycode)", nativeQuery = true)
    void savePhone( @Param("uuid") String uuid,@Param("number") String number,@Param("citycode") String citycode,@Param("contrycode") String contrycode);
}
