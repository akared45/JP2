import Entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //B1:File path
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/", "\\") + "/data/customer.in.txt";
        String fileOutPath = sysPath.replace("/", "\\") + "/data/customer.out.txt";

        List<Customer> customerList = new ArrayList<>();
        //convert Windows

        //B2:Read file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath));
            String lineData;
            while ((lineData = bufferedReader.readLine()) != null) {
                Customer customer = new Customer();
                if (!lineData.isEmpty()) {
                    String[] arrData = lineData.split(";");
                    customer.setId(Integer.parseInt(String.valueOf(arrData[0])));
                    customer.setCodeCus(String.valueOf(arrData[1]));
                    customer.setName(String.valueOf(arrData[2]));
                }
                customerList.add(customer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //Sort and display
        Set<Customer> customerSet = customerList.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toSet());
        customerSet.forEach(customer -> System.out.println(customer.toString("|")));

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutPath));
            customerSet.stream().peek(customer -> {
                try {
                    String lineWrite = customer.toString("|");
                    bufferedWriter.write(lineWrite);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }).collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}