package re.mvc.bai1.repository;

import org.springframework.stereotype.Repository;

@Repository

public class OrderRepository {
    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id){
        return "thong tin có don hang co id: " + id;
    }
    public String createOrder(String createOrder){
        return "don hang duoc tao " + createOrder;
    }

    public String addOrder(){
        return " don hang duoc them" ;
    }
}
