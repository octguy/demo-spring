package com.example.jpansecurity.repository;

import com.example.jpansecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Spring Data JPA sẽ tự động tạo implementation cho method này
    Optional<User> findByUsername(String username);
    
    // Kiểm tra xem username đã tồn tại chưa
    boolean existsByUsername(String username);
    
    // Tìm theo email
    Optional<User> findByEmail(String email);
}
