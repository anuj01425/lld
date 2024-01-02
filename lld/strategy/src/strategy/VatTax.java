package strategy;

public class VatTax implements Tax{
    @Override
    public double calculateTax(double amount) {
        return amount*12;
    }
}
