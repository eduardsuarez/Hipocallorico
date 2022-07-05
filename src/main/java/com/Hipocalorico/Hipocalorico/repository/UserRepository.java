/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.repository;

import com.Hipocalorico.Hipocalorico.entity.User;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.UserCrudRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class UserRepository implements Serializable {

    @Autowired
    private UserCrudRepository crudRepository;

    public List<User> getUsers() {
        return (List<User>) crudRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return crudRepository.findById(id);
    }

    public Boolean existeEmail(String email) {
        Optional<User> usuario = crudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return crudRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return crudRepository.save(user);
    }

    public User update(User user) {
        return crudRepository.save(user);
    }

    public void delete(User user) {
        crudRepository.delete(user);
    }

    public Optional<User> lastUserId() {
        return crudRepository.findTopByOrderByIdDesc();
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return crudRepository.findByMonthBirthtDay(monthBirthtDay);
    }

}
