/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.entity.crudRepository;

import com.Hipocalorico.Hipocalorico.entity.Supplement;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Eduard Suárez
 */
public interface SupplementCrudRepository extends MongoRepository<Supplement, String> {

    public List<Supplement> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Supplement> findByDescriptionLike(String description);
}
