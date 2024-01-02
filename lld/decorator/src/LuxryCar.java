public class LuxryCar extends Decorator {
    public LuxryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Luxry Car.");
    }
}
