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

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public User save(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = repository.getUserById(user.getId());
            if (e.isEmpty()) {
                if (existeEmail(user.getEmail()) == false) {
                    return repository.saveUser(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repository.getUserById(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                repository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Optional<User> usuario = getUserById(userId);

        if (usuario.isEmpty()) {
            return false;
        } else {
            repository.delete(usuario.get());
            return true;
        }

    }
}
