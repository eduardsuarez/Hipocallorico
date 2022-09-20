/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.repository;

import com.Hipocalorico.Hipocalorico.entity.Supplement;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.SupplementCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eduard Suárez
 */
@Repository
public class SupplementRepository {
    @Autowired
    private SupplementCrudRepository crudRepository;

    public List<Supplement> getAllSupplements() {
        return crudRepository.findAll();
    }

    public Optional<Supplement> getSupplement(String reference) {
        return crudRepository.findById(reference);
    }

    public Supplement save(Supplement clothe) {
        return crudRepository.save(clothe);
    }

    public void update(Supplement clothe) {
        crudRepository.save(clothe);
    }

    public void delete(Supplement clothe) {
        crudRepository.delete(clothe);
    }
    
    public List<Supplement> gadgetsByPrice(double precio) {
        return crudRepository.findByPriceLessThanEqual(precio);
    }
    //
    public List<Supplement> findByDescriptionLike(String description) {
        return crudRepository.findByDescriptionLike(description);
    }
    
}
