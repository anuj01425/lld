//adapter pattern has 3 terms
//target - > the interface that client supports
//adaptee -> ther interface that internal service supports
//bridge -> the implementation that acts as bridge between target and adaptee
//Real world analogy
//Suppose you have a laptop (the client) that needs to charge its battery.
// The laptop's charging port is a USB-C port (the Target interface),
// but the charger you have is designed for a standard electrical outlet (the Adaptee interface).
// You need an adapter (the Adapter class) to bridge the gap between the laptop's USB-C port and
// the charger's electrical plug.


public class Main {
    public static void main(String[] args) {

        //old implementation

        Target basic = new BasicMediaPlayer();
        basic.play("mp3");

        //new implementation
        System.out.println("Hello world!");
        Adaptee adaptee = new AdapteeMediaPlayer();

        //has same interface which client is expecting
        Target adapter = new MediaPlayer(adaptee);
        adapter.play("mp4");
    }
}