package com.api.Usuarios.service;

import com.api.Usuarios.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CheckMailService {

    @Autowired
    IUserRepository userRepository;

    public int checkMail (String email){
        return this.userRepository.checkMail(email);
    }

    public boolean checkFormatMail (String mail){

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }
}
