package bai3.controller;

import bai3.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String orders(HttpSession session, ServletContext application, Model model) {
        Object loggedUser = session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD001", "Bàn phím cơ", 1250000, createDate(1)));
        orders.add(new Order("OD002", "Chuột gaming", 750000, createDate(2)));
        orders.add(new Order("OD003", "Tai nghe Bluetooth", 1590000, createDate(3)));
        orders.add(new Order("OD004", "Màn hình 24 inch", 3290000, createDate(4)));

        model.addAttribute("orders", orders);

        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            application.setAttribute("totalViewCount", count + 1);
        }

        return "orders";
    }

    private java.util.Date createDate(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2026);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}