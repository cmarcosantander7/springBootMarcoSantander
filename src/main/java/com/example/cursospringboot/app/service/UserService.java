package com.example.cursospringboot.app.service;

import com.example.cursospringboot.app.entity.User;
import com.example.cursospringboot.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private S3Service s3Service;

    public boolean create(User usuarioRequest){
        try {
            userRepository.save(usuarioRequest);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(User usuarioRequest){
        try {
            userRepository.save(usuarioRequest);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<User> getUsers(){
        return userRepository.findAll()
                .stream()
                .peek(usuario -> usuario.setFotoUrl(s3Service.getObjectURL(usuario.getFoto())))
                .peek(usuario -> usuario.setCedulaUrl(s3Service.getObjectURL(usuario.getCedula())))
                .collect(Collectors.toList());
    }
    public User getUserbyId(Long id){
        if (userRepository.existsById(id)){
            return userRepository.getById(id);
        }
        return null;
    }
    public boolean deleteUsuerbyId(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
