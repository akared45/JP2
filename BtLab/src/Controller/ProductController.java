package Controller;

import Service.ProductService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.Map;
import java.util.Scanner;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void productClickPercent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month 1:  ");
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
        String fileOutPath=sysPath.replace("/","\\")+"/src/data/product.out.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutPath))) {
            for (Map.Entry<String, Integer> entry : totalClicksPerCode.entrySet()) {
                String code = entry.getKey();
                int totalClicksForProduct = entry.getValue();
                bufferedWriter.write("Total clicks for products with code " + code + ": " + totalClicksForProduct);
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
