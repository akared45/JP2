package Service;

import Entity.Product;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public void setProducts(List<Product> products) {
        this.productList = products;
    }

    public Map<String, Integer> totalClicksPerCode(Month month) {
        return productList.stream()
                .filter(product -> product.getCheckOut().getMonth() == month)
                .collect(Collectors.groupingBy(
                        Product::getCodeProduct,
                        Collectors.summingInt(Product::getClick)
                ));
    }

    public int totalClicksForMonth(Month month) {
        return productList.stream()
                .filter(product -> product.getCheckOut().getMonth() == month)
                .mapToInt(Product::getClick)
                .sum();
    }

}
