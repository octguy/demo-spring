package com.example.jpansecurity.config;

import com.example.jpansecurity.entity.User;
import com.example.jpansecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        // Tạo tài khoản admin mặc định nếu chưa có
        if (!userService.existsByUsername("admin")) {
            userService.createUser("admin", "admin123", "admin@example.com", User.Role.ADMIN);
            System.out.println("Đã tạo tài khoản admin mặc định:");
            System.out.println("Username: admin");
            System.out.println("Password: admin123");
        }
    }
}
