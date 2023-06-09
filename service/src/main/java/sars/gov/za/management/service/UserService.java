/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sars.gov.za.management.domain.User;
import sars.gov.za.management.persistence.UserRepository;


/**
 *
 * @author S2028873
 */
@Service
public class UserService implements UserServiceLocal {
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public User save(User user) {
     return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("the requested id [" +id+ "] does not exist"));
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User deleteById(Long id) {
        User user =findById(id);
        if(user!=null){
        userRepository.deleteById(id);
        }
        return user;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean isExist(User user) {
        return userRepository.findById(user.getId())!=null;
    }

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {
      return userRepository.findUserByUserNameAndPassword(userName, password);
    }
}

