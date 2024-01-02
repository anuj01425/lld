package strategy;

public class DutyTax implements Tax{
    @Override
    public double calculateTax(double amount) {
        return amount*10;
    }
}
