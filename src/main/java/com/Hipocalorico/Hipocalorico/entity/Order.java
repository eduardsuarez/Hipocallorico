/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hipocalorico.Hipocalorico.entity;

import java.util.Date;
import java.util.Map;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Eduard Suárez
 */

@Document(collation = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    public static String PENDING = "pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    
    private Map<String, Supplement> products;
    private Map<String, Integer> quantities;
    
    
}
