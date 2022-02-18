package com.example.cursospringboot.app.controller;

import com.example.cursospringboot.app.entity.User;
import com.example.cursospringboot.app.repository.UserRepository;
import com.example.cursospringboot.app.service.S3Service;
import com.example.cursospringboot.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody User user){

        if (userService.create(user)){
            return new ResponseEntity(true,HttpStatus.CREATED);
        }
        return new ResponseEntity(false,HttpStatus.NOT_FOUND);
    }


    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<User> read (@PathVariable Long id){
        User usuariosbyId = userService.getUserbyId(id);
        return new ResponseEntity<User>(usuariosbyId,HttpStatus.OK);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody User userDetails,@PathVariable Long id ){
        if (userService.update(userDetails)){
            return new ResponseEntity(true,HttpStatus.CREATED);
        }
        return new ResponseEntity(false,HttpStatus.NOT_FOUND);
    }

    //Delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if (userService.deleteUsuerbyId(id)){
            return new ResponseEntity(true,HttpStatus.CREATED);
        }
        return new ResponseEntity(false,HttpStatus.NOT_FOUND);
    }

    //Read all user
    @GetMapping
    public ResponseEntity<List<User>> readAll(){
        List<User> us = userService.getUsers();
        return new ResponseEntity<List<User>>(us,HttpStatus.OK);
    }




}
