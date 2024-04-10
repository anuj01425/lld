//bridge between client and server interface
public class MediaPlayer implements Target{
    public Adaptee adaptee;
    public MediaPlayer(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void play(String file) {
        if(file.endsWith("mp3")){
            adaptee.playMp3(file);
        }
        if(file.endsWith("mp4")){
            adaptee.playMp4("mp4");
        }
        throw new RuntimeException("Not supported");
    }
}
