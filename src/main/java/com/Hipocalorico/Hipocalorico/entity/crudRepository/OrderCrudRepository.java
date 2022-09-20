/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.entity.crudRepository;

import com.Hipocalorico.Hipocalorico.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Eduard Suárez
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    //Retorna las ordenes de pedido que coincidan con la zona recibida como parámetro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    // Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
    
    
    
}
