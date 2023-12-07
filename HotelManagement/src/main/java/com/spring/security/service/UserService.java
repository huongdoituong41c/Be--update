package com.spring.security.service;

import com.spring.security.dto.UserDTO;
import com.spring.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

     @Autowired
     boolean registerUser (UserDTO userDTO) ;
     @Autowired
     boolean login (UserDTO userDTO);

     boolean checkPassword(String email, String password) ;

     Optional<User> findByEmail(String email);
     List<User> getAllUser ();

     Optional<User> findById (Long id);

     User update (Long id, UserDTO userDTO);

     void deleteById (Long id);
}
