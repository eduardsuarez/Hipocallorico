/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.entity.crudRepository;

import com.Hipocalorico.Hipocalorico.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author eduar
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
    
    Optional<User> findTopByOrderByIdDesc();
    
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
