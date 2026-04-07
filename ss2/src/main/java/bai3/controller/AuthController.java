package bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {

        if ("admin".equals(username) && "admin123".equals(password)) {
            session.setAttribute("loggedUser", "admin");
            session.setAttribute("role", "ADMIN");
            return "redirect:/orders";
        }

        if ("staff".equals(username) && "staff123".equals(password)) {
            session.setAttribute("loggedUser", "staff");
            session.setAttribute("role", "STAFF");
            return "redirect:/orders";
        }

        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}