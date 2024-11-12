import Controller.ProductController;
import Service.ProductService;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService(new ArrayList<>());
        ProductController productController = new ProductController(productService);
        productController.loadProductsFromFile();
        productController.productClickPercent();
    }
}
