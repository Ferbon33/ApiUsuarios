package com.api.Usuarios.service;

import com.api.Usuarios.Dto.SucessResponseDTO;
import com.api.Usuarios.Dto.UsuarioDTO;
import com.api.Usuarios.models.PhoneModel;
import com.api.Usuarios.models.UserModel;
import com.api.Usuarios.repository.IPhonesRepository;
import com.api.Usuarios.repository.IUserRepository;
import com.api.Usuarios.security.GeneredJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPhonesRepository phonesRepository;

    @Autowired
    GeneredJWT generedJWT;

    public ArrayList<UserModel> getUsers(){
          return (ArrayList<UserModel>) userRepository.findAll();
    }


    public SucessResponseDTO saveUser(UsuarioDTO userDto){

        LocalDateTime dateTime = LocalDateTime.now();
        UserModel user = new UserModel();
        UserModel userResp = new UserModel();
        SucessResponseDTO response = new SucessResponseDTO();

        ///creamos valor unico de cliente UUID
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        String jwt = this.generedJWT.generedJWT(userDto.getName());


        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setToken(jwt);
        user.setUuid(uuidStr);
        user.setLast_login(dateTime);
        user.setCreated(dateTime);
        user.setModified(dateTime);

        int sizePhone = userDto.getPhones().size();
        for(int i=0;i<sizePhone;i++){

            this.phonesRepository.savePhone(
                    uuidStr,
                    userDto.getPhones().get(i).getNumber(),
                    userDto.getPhones().get(i).getContrycode(),
                    userDto.getPhones().get(i).getContrycode());
        }
       userResp = this.userRepository.save(user);

       response.setUser(userDto.getName());
       response.setId(userResp.getId());
       response.setToken(userResp.getToken());
       response.setCreated(userResp.getCreated());
       response.setModified(userResp.getModified());
       response.setLastLogin(userResp.getLast_login());
       response.setIsactive(true);
        return response;
    }



    ////Utilizo la clase Optional para evitar problamas con Null
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request,Long id){


        LocalDateTime dateTime = LocalDateTime.now();
        int ok =   this.userRepository.UpdateUser(request.getName(),request.getEmail(),request.getPassword(),id,dateTime);
        System.out.println("salida fer" + ok);


        return request;
    }

    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
