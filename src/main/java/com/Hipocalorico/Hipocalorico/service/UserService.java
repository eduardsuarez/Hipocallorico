/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.service;

import com.Hipocalorico.Hipocalorico.entity.User;
import com.Hipocalorico.Hipocalorico.repository.UserRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class UserService implements Serializable {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public Optional<User> getUserById(int id) {
        return repository.getUserById(id);
    }

    public User saveUser(User user) {
        return repository.saveUser(user);
    }

    public boolean existeEmail(String email) {
        return repository.existeEmail(email);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return repository.saveUser(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO!");
        } else {
            return usuario.get();
        }
    }

}
