package com.example.lab_15_last_lat;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products {
     private Map<Integer, Product> productMap ;


    private static int ID;

    public Products() throws IOException {
        ID = 0;
        //getData();
        productMap = new HashMap<>();
        getData();
    }


    public void addProduct(String name, String description) {
        ID++;
        Product product = new Product(name, description, ID);
        productMap.put(product.getId(), product);
      //  Date time = new Date();
    }

    public Product getProduct(int id) {
        return productMap.get(id);
    }

    public void setData() throws IOException {
        FileWriter fileWriter = new FileWriter("products.txt");
        for (Product product : productMap.values()) {
            fileWriter.write(product.getName() + "\n");
            fileWriter.write(product.getDescription() + "\n");
            fileWriter.write(product.getId() + "\n");
        }
        fileWriter.close();
    }

    public void getData() throws IOException {
        Path path = Paths.get("C:\\Program Files\\apache-tomcat-10.0.27\\bin\\products.txt");
        Scanner scanner = new Scanner(path);

        int idx = 0;
//        productMap = new HashMap<>();
        while (scanner.hasNextLine()){
            Product product = new Product();
            product.setName(scanner.nextLine());
            product.setDescription(scanner.nextLine());
            product.setId( Integer.parseInt(scanner.nextLine()));
            ID = product.getId();
            productMap.put(product.getId(), product);
        }

    }

    public String getBooksForPrint() {
        System.out.println("hi");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table>");
        for (int i = 0; i < 3; i++) {
            System.out.println("hi1");
            stringBuilder.append("<tr>");
            for (int j = 0; j < 3; j++) {
                System.out.println("hi2");
                if (productMap.containsKey(i * 3 + j)) {
                    System.out.println("h3");
                    stringBuilder.append("<td>");
                    stringBuilder.append("<h4>" + productMap.get(i * 3 + j).getName() + "<h4>");
//                    stringBuilder.append("<h4>Price:" + productMap.get(i * 4 + j).getPrice() + "</h4>");
                    stringBuilder.append("<form action=\"ProductServlet\" method=\"get\">\n");
                    stringBuilder.append("<input type=\"hidden\" name=\"id\" value=\"" + (i * 3 + j) + "\">");
                    stringBuilder.append("<input type=\"submit\" value=\"more info\" >");
                    stringBuilder.append("</form>");
                    stringBuilder.append("</td>");
                } else {
                    System.out.println("hi4");
                    stringBuilder.append("<td>");
                    stringBuilder.append("<h4>" + "<h4>");
                    stringBuilder.append("</td>");
                }
            }
            stringBuilder.append("<tr>");
        }
        System.out.println("h5");
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }
}
