/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.entity.crudRepository;

import com.Hipocalorico.Hipocalorico.entity.Supplement;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Eduard Suárez
 */
public interface SupplementCrudRepository extends MongoRepository<Supplement, String>{
    
}
