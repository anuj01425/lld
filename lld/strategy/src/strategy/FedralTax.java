package strategy;

public class FedralTax implements Tax{
    @Override
    public double calculateTax(double amount) {
        return amount*11;
    }
}
