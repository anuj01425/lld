/**
 * Convert the interface of a class into another interface clients expect.
 * https://www.digitalocean.com/community/tutorials/adapter-design-pattern-java
 */



public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SocketAdapter socketAdapter = new AdapterObjImpl();
        System.out.println(socketAdapter.volt3().getVolts());
    }
}