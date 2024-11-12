package Controller;

import Entity.Product;
import Service.ProductService;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void loadProductsFromFile() {
        List<Product> products = new ArrayList<>();
        String sysPath=System.getProperty("user.dir");
        String fileInPath=sysPath.replace("/","\\")+"/BtLab/src/data/product.in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileInPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String code = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                int price = Integer.parseInt(parts[3].trim());
                LocalDate date = LocalDate.parse(parts[4].trim());
                products.add(new Product(id, code, quantity, price, date));
            }
            productService.setProducts(products);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void productClickPercent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int monthInt = scanner.nextInt();
        Month month = Month.of(monthInt);

        Map<String, Integer> totalClicksPerCode = productService.totalClicksPerCode(month);
        int totalClicks = productService.totalClicksForMonth(month);

        totalClicksPerCode.forEach((code, totalClicksForProduct) -> {
            System.out.println("Total clicks for product code " + code + ": " + totalClicksForProduct);
            double percentage = totalClicksForProduct * 100.0 / totalClicks;
            System.out.printf("Percentage: %.2f%%\n", percentage);
        });

        String sysPath=System.getProperty("user.dir");
        String fileOutPath=sysPath.replace("/","\\")+"/BtLab/src/data/product.out.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutPath))) {
            for (Map.Entry<String, Integer> entry : totalClicksPerCode.entrySet()) {
                String code = entry.getKey();
                int totalClicksForProduct = entry.getValue();
                bufferedWriter.write("Total clicks for product code " + code + ": " + totalClicksForProduct);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Total clicks for the month: " + totalClicks);
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> entry : totalClicksPerCode.entrySet()) {
                String code = entry.getKey();
                int totalClicksForProduct = entry.getValue();
                double percentage = (totalClicksForProduct * 100.0) / totalClicks;
                bufferedWriter.write(String.format("Total clicks for product code %s: %d, Percentage: %.2f%%",
                        code, totalClicksForProduct, percentage));
                bufferedWriter.newLine();
            }
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
