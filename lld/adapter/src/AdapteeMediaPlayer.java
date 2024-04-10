public class AdapteeMediaPlayer implements Adaptee {
    @Override
    public void playMp3(String file) {
        if(file.endsWith("mp3")){
            System.out.println("Eligible for mp3");
        }
        else throw new RuntimeException("Not supported");
    }

    @Override
    public void playMp4(String file) {
        if(file.endsWith("mp4")){
            System.out.println("Eligible for mp3");
        }
        else throw new RuntimeException("Not supported");
    }
}
