package com.Hipocalorico.Hipocalorico;

import com.Hipocalorico.Hipocalorico.entity.Order;
import com.Hipocalorico.Hipocalorico.entity.Supplement;
import com.Hipocalorico.Hipocalorico.entity.User;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.OrderCrudRepository;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.SupplementCrudRepository;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HipocaloricoApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository UserRepository;

    @Autowired
    private SupplementCrudRepository suppRepo;
    
    @Autowired
    private OrderCrudRepository orderRepo;

    public static void main(String[] args) {
        SpringApplication.run(HipocaloricoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserRepository.deleteAll();
        suppRepo.deleteAll();
        orderRepo.deleteAll();
        
        //Para efectos de formateo de fechas
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        UserRepository.saveAll(
                List.of(new User(1, "453423", "JUANA LA LOCA", ft.parse("1986-11-15"), "11", "CL 34 NRO AAA..", "234123", "juanaloca@gmail.com", "Demo123.", "ZONA 1", "ADM"),
                        new User(2, "165413", "Eduard Suárez", ft.parse("1998-09-21"), "09", "CL 34 NRO AAA..", "10942", "suareze205@gmail.com", "qwerty.", "ZONA 1", "ADM"),
                        new User(3, "32564", "BLODY MARRY", ft.parse("1996-05-29"), "05", "CL 34 NRO AAA..", "321598464", "stellez@gmail.com", "qwerty.", "ZONA 2", "COORD"),
                        new User(4, "82642", "JUANA DE ARCO", ft.parse("1987-05-15"), "05", "CL 34 NRO AAA..", "6365945", "jdarco@gmail.com", "qwerty.", "ZONA 2", "ASE"),
                        new User(5, "132846", "ALCIRA LA ALPACA", ft.parse("1966-02-15"), "02", "CL 34 NRO AAA..", "5666648", "aalpaca@gmail.com", "qwerty.", "ZONA 1", "COORD"),
                        new User(6, "745844", "PEDRO CAPAROSA", ft.parse("1966-02-15"), "02", "CL 34 NRO AAA..", "866698", "pcaparosa@gmail.com", "qwerty.", "ZONA 1", "ASE")
                ));

        suppRepo.saveAll(
                List.of(new Supplement("AP-903", "MARCA 1", "CATEGORIA 1", "OBJETIVO 1", "descripción", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
                        new Supplement("AP-904", "MARCA 2", "CATEGORIA 2", "OBJETIVO 2", "descripción", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg")
                )
        );
//        System.out.println("Listado de usuarios");
//        UserRepository.findAll().forEach(System.out::println);
//
//        System.out.println("Listado de suplementos");
//        suppRepo.findAll().forEach(System.out::println);

        //Instanciar las ordenes
        Order orderOne = new Order();
        orderOne.setId(1);
        Order orderTwo = new Order();
        orderTwo.setId(2);
        
        Order orderThree = new Order();
        orderThree.setId(3);
        //Recuperar vendedores
        Optional<User> salesManOne = UserRepository.findById(3);
        Optional<User> salesManTwo = UserRepository.findById(6);
        
        //Mapa de productos asociados a una orden
        
        Map<String, Supplement> productOrderOne = new HashMap<String, Supplement>();
        Map<String, Supplement> productOrderTwo = new HashMap<String, Supplement>();
        Map<String, Supplement> productOrderThree = new HashMap<String, Supplement>();
        
        //Mapa de cantidades de producto asociados a una orden
        Map<String, Integer> quantitiesOrderOne = new HashMap<String, Integer>();
        Map<String, Integer> quantitiesOrderTwo = new HashMap<String, Integer>();
        Map<String, Integer> quantitiesOrderThree = new HashMap<String, Integer>();
        
        // Lista de productos de la orden 1
        productOrderOne.put("AP-903", suppRepo.findById("AP-903").get());
        productOrderOne.put("AP-904", suppRepo.findById("AP-904").get());
        
        //Cantidades de producto de la orden 1
        quantitiesOrderOne.put("AP-903", 1);
        quantitiesOrderOne.put("AP-904", 1);
        
        // Lista de productos de la orden 1
        productOrderTwo.put("AP-903", suppRepo.findById("AP-903").get());
        productOrderTwo.put("AP-904", suppRepo.findById("AP-904").get());
        
        //Cantidades de producto de la orden 2
        quantitiesOrderTwo.put("AP-903", 1);
        quantitiesOrderTwo.put("AP-904", 1);
        
        // Lista de productos de la orden 3
        productOrderThree.put("AP-904", suppRepo.findById("AP-904").get());
        
        //Cantidades de producto de la orden 1
        quantitiesOrderOne.put("AP-904", 10);

        
        
        
        //Configuración datos orden 1
        orderOne.setRegisterDay(ft.parse("2021-09-15"));
        orderOne.setStatus(Order.PENDING);
        orderOne.setSalesMan(salesManOne.get());
        orderOne.setProducts(productOrderOne);
        orderOne.setQuantities(quantitiesOrderOne);
        
        //Configuración datos orden 2
        orderTwo.setRegisterDay(ft.parse("2021-09-15"));
        orderTwo.setStatus(Order.PENDING);
        orderTwo.setSalesMan(salesManTwo.get());
        orderTwo.setProducts(productOrderTwo);
        orderTwo.setQuantities(quantitiesOrderTwo);
        
         //Configuración datos orden 2
        orderThree.setRegisterDay(ft.parse("2021-06-12"));
        orderThree.setStatus(Order.PENDING);
        orderThree.setSalesMan(salesManTwo.get());
        orderThree.setProducts(productOrderThree);
        orderThree.setQuantities(quantitiesOrderThree);
        
        
        //Registra las ordenes en la base de datos
        //imprime los datos de las ordenes
        orderRepo.saveAll(List.of(orderOne, orderTwo, orderThree));
        System.out.println("Listado de ordenes");
        orderRepo.findAll().forEach(System.out::println);
        
    
    }

}
