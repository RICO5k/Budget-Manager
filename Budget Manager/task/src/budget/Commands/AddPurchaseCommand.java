package budget.Commands;

import budget.Budget;
import budget.Purchase;

import java.util.Scanner;

public class AddPurchaseCommand implements Command {

    private Scanner scanner;
    private Budget budget;

    public AddPurchaseCommand(Budget budget, Scanner scanner) {
        this.budget = budget;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        String name = getName();
        double price = getPrice();

        budget.addPurchase( new Purchase(name, price) );
    }

    private String getName() {
        System.out.println("Enter purchase name: ");
        return scanner.nextLine();
    }

    private double getPrice() {
        System.out.println("enter its price: ");
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Add purchase";
    }
}
