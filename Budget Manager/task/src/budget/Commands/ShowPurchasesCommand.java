package budget.Commands;

import budget.Budget;

import java.util.List;

public class ShowPurchasesCommand implements Command {

    private Budget budget;

    public ShowPurchasesCommand(Budget budget) {
        this.budget = budget;
    }

    @Override
    public void execute() {
        List<String> purchaseStrings = budget.getPurchaseStrings();

        if( purchaseStrings.isEmpty() ) {
            System.out.println("Purchase list is empty");
            return;
        }

        for(String purchase : purchaseStrings) {
            System.out.println(purchase);
        }

        System.out.println( "Total sum: $" + budget.getPurchasesSum() );


    }

    @Override
    public String toString() {
        return "Show list of purchases";
    }
}
