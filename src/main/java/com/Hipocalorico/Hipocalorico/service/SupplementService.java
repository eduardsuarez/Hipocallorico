/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.service;

import com.Hipocalorico.Hipocalorico.entity.Supplement;
import com.Hipocalorico.Hipocalorico.repository.SupplementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduard Suárez
 */
@Service
public class SupplementService {

    @Autowired
    private SupplementRepository repository;

    public List<Supplement> getAllSuplements() {
        return repository.getAllSupplements();
    }

    public Optional<Supplement> getSupplementId(String reference) {
        return repository.getSupplement(reference);
    }

    public Supplement save(Supplement supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return repository.save(supplement);
        }
    }

    public Supplement update(Supplement supplement) {

        if (supplement.getReference() != null) {
            Optional<Supplement> supplementDb = repository.getSupplement(supplement.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                repository.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplementId(reference).map(supplement -> {
            repository.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //
    public List<Supplement> gadgetsByPrice(double price) {
        return repository.gadgetsByPrice(price);
    }

    //
    public List<Supplement> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
