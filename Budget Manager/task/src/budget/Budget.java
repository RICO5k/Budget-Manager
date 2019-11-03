package budget;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private double balance;

    private List<Purchase> purchases;

    public Budget() {
        this.balance = 0;

        this.purchases = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addIncome(double income) {
        this.balance += income;
    }

    public void addPurchase(Purchase purchase) {
        reduceBalance( purchase.getPrice() );
        purchases.add( purchase );
    }

    public void reduceBalance(double value) {
        balance -= value;
        if(balance < 0) balance = 0;
    }

    public List<String> getPurchaseStrings() {
        List<String> purchaseStrings = new ArrayList<>();

        for( Purchase purchase : purchases ) {
            purchaseStrings.add( purchase.toString() );
        }

        return purchaseStrings;
    }

    public double getPurchasesSum() {
        double sum = 0;

        for( Purchase purchase : purchases ) {
            sum += purchase.getPrice();
        }

        return sum;
    }
}
