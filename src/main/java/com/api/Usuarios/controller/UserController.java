package com.api.Usuarios.controller;

import com.api.Usuarios.Dto.BaseDTO;
import com.api.Usuarios.Dto.ErrorResponseDTO;
import com.api.Usuarios.Dto.SucessResponseDTO;
import com.api.Usuarios.Dto.UsuarioDTO;
import com.api.Usuarios.models.UserModel;
import com.api.Usuarios.service.CheckMailService;
import com.api.Usuarios.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CheckMailService checkMailService;



    @PostMapping(path = "/saveUser")
    public BaseDTO saveUser(@RequestBody UsuarioDTO userDto){

      ErrorResponseDTO errorResp = new ErrorResponseDTO();
      int email = this.checkMailService.checkMail(userDto.getEmail());
      boolean formatMail = this.checkMailService.checkFormatMail(userDto.getEmail());
      if(!formatMail){

          errorResp.setMensaje("Error, Formato de mail incorrecto");
          return errorResp;
      }else if (email>0){

          errorResp.setMensaje("Error, Email Ya existe");
          return errorResp;
      }else{ return this.userService.saveUser(userDto);}



    }
    @GetMapping(path = "/getAllUser")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping(path = "/getUserById/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
      return  this.userService.getById(id);
    }

    @PutMapping(path = "/UpdateUserById/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable Long id){
        return this.userService.updateById(request,id);
    }

    @DeleteMapping(path = "/DeleteUserById/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User whith id " + id + " deleted";
        }else {
            return "Error, we have a problem " + id;
        }
    }


}
