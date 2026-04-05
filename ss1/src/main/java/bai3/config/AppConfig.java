package bai3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// AppConfig là class cấu hình Spring.
// Dùng để bật cơ chế quét các bean trong package bai3,
// giúp Spring tạo và quản lý các object có annotation như:
// @Repository, @Service
@ComponentScan(basePackages = "bai3")
public class AppConfig {
}