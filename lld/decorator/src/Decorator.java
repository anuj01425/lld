public abstract class Decorator implements Car {
    protected Car car;
    public Decorator(Car c){
        this.car=c;
    }
    @Override
    public void assemble() {
        this.car.assemble();
    }
}
