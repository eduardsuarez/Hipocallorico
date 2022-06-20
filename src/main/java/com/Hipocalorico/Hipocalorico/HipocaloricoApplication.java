package com.Hipocalorico.Hipocalorico;

import com.Hipocalorico.Hipocalorico.entity.Supplement;
import com.Hipocalorico.Hipocalorico.entity.User;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.SupplementCrudRepository;
import com.Hipocalorico.Hipocalorico.entity.crudRepository.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    public static void main(String[] args) {
        SpringApplication.run(HipocaloricoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        UserRepository.deleteAll();
//        suppRepo.deleteAll();
        //Para efectos de formateo de fechas
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        UserRepository.saveAll(
//                List.of(new User(1, "453423", "JUANA LA LOCA",  "CL 34 NRO AAA..", "234123", "juanaloca@gmail.com", "Demo123.", "ZONA 1", "ADM"),
//                        new User(2, "165413", "Eduard Suárez",  "CL 34 NRO AAA..", "10942", "suareze205@gmail.com", "qwerty.", "ZONA 1", "ADM")
//                ));

//        suppRepo.saveAll(
//                List.of(new Supplement("AP-903", "MARCA 1", "CATEGORIA 1", "OBJETIVO 1", "descripción", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg")
//                )
//        );
//        System.out.println("Listado de usuarios");
//        UserRepository.findAll().forEach(System.out::println);
        
//        System.out.println("Listado de suplementos");
//        suppRepo.findAll().forEach(System.out::println);

    }

}
