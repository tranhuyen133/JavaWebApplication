package re.mvc.service;

import org.springframework.stereotype.Service;
import re.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static List<Product>  productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Iphone 17 Pro Max", "iPhone 17 Pro Max 256GB | Chính hãng | 2TB","https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/i/p/iphone-17-pro-max_3.jpg",37790000));
        productList.add(new Product(2,"Lenovo Think Pad E14", "Laptop Lenovo ThinkPad E14 Gen 7 21U2003QVN","https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/s/s/ssss_1__1_57.png",28990000));
    }
    public List<Product> getProductList() {
        return productList;
    }

    public void add.product(Product product) {
        productList.add(product);
    }
    public updateProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                return;
            }
        }
    }
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

}