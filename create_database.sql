-- ===================================================================
-- CREATE DATABASE FOR SPRING SECURITY JPA DEMO
-- ===================================================================

-- Tạo database mới
CREATE DATABASE IF NOT EXISTS jpansecurity_db 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

-- Sử dụng database
USE jpansecurity_db;

-- Hiển thị thông tin
SELECT 'Database jpansecurity_db đã được tạo thành công!' as message;
