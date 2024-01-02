package context;

import strategy.Tax;

public class Context {

    private Tax tax;

    public Context(Tax tax){
        this.tax=tax;
    }

    public double calculateTax(double amount){
        return tax.calculateTax(amount);
    }
}
