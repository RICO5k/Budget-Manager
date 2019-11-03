package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productList = new ArrayList<>();
        double totalPrice = 0;

        while(scanner.hasNextLine()) {
            String product = scanner.nextLine();

            double price = Double.parseDouble(product.split("\\$")[1]);

            productList.add(product);
            totalPrice += price;
        }

        for(String product : productList) {
            System.out.println(product);
        }

        System.out.println("Total: $" + totalPrice);
    }
}
