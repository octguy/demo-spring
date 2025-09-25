package com.example.jpansecurity.service;

import com.example.jpansecurity.entity.User;
import com.example.jpansecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // Tạo user mới
    public User createUser(String username, String password, String email, User.Role role) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username đã tồn tại!");
        }
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Mã hóa password
        user.setEmail(email);
        user.setRole(role);
        
        return userRepository.save(user);
    }
    
    // Tìm user theo username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    // Lấy tất cả users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Xóa user theo ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    // Kiểm tra username có tồn tại không
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
