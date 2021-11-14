package com.userservice.userservice;

import com.userservice.userservice.domain.AppUser;
import com.userservice.userservice.domain.Role;
import com.userservice.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        // every time app started
        return arg -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "wassim souilah", "w4s", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "WILL SMITH", "WS", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "EDZ WASSIM", "EW", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "JOHN DOE", "JD", "1234", new ArrayList<>()));

            userService.addRoleToUser("WS", "ROLE_USER");
            userService.addRoleToUser("EW", "ROLE_MANAGER");
            userService.addRoleToUser("JD", "ROLE_ADMIN");
            userService.addRoleToUser("JD", "ROLE_USER");
            userService.addRoleToUser("w4s", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("w4s", "ROLE_USER");


        };
    }
}
