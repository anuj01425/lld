public class Main {

    /**
     * Is a structural design pattern that removes the complexity arising because of different inheritance of different combination of objects
     * https://www.digitalocean.com/community/tutorials/decorator-design-pattern-in-java-example
     */

    public static void main(String[] args) {

        Car car = new SportsCar(new BasicCar());
        Car car1 = new SportsCar(new LuxryCar(new BasicCar()));

        car.assemble();
        car1.assemble();
    }
}