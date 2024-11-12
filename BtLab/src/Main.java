import Controller.ProductController;
import Entity.Product;
import Service.ProductService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1,"C001",10,10, LocalDate.now()));
        products.add(new Product(2,"C001",20,20, LocalDate.now().plusDays(1)));
        products.add(new Product(3,"C001",30,30, LocalDate.now().plusMonths(3)));
        products.add(new Product(4,"C002",1,1, LocalDate.now()));
        products.add(new Product(5,"C002",2,2, LocalDate.now().plusMonths(1)));
        products.add(new Product(6,"C002",10,10, LocalDate.now().plusDays(5)));
        products.add(new Product(7,"C003",32,10, LocalDate.now().plusDays(2)));

        ProductService productService=new ProductService(products);
        ProductController productController=new ProductController(productService);
        productController.productClickPercent();

    }
}