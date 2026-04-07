package bai1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // Bắt toàn bộ request gửi vào ứng dụng
        return new String[]{"/"};
    }
}
//# Phần 1 — Phân tích logic
//
//## 1. Lỗi trong `MyWebAppInitializer.java`
//
//Trong `MyWebAppInitializer.java`, nếu `DispatcherServlet` được cấu hình với mapping `"/api/*"` thì điều đó có nghĩa là `DispatcherServlet` chỉ tiếp nhận những request có đường dẫn bắt đầu bằng `/api/`.
//
//        Ví dụ, servlet sẽ xử lý các URL như:
//
//        - `/api/welcome`
//        - `/api/login`
//        - `/api/orders`
//
//Nhưng trong đề bài, người dùng truy cập URL:
//
//        `http://localhost:8080/demo/welcome`
//
//Đường dẫn này chỉ là `/welcome`, không có tiền tố `/api`, nên request đó không được chuyển vào `DispatcherServlet`. Khi request không đi vào `DispatcherServlet`, Spring MVC sẽ không thực hiện được các bước tiếp theo như tìm `HandlerMapping`, gọi `Controller`, và phân giải `View`. Vì vậy, Tomcat sẽ trả về lỗi **HTTP 404 — Not Found**.
//
//Nói cách khác, với cấu hình `"/api/*"`, `DispatcherServlet` đang nghe chỉ các URL dạng `/api/...`, còn `/welcome` thì không nằm trong phạm vi xử lý của servlet này.
//
//---
//
//        ## 2. Lỗi trong `WebConfig.java`
//
//Nếu trong `WebConfig.java` có cấu hình:
//
//        ```java
//@ComponentScan(basePackages = "com.demo.service")