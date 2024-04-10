public class BasicMediaPlayer implements Target{
    @Override
    public void play(String file) {
        System.out.println("Playing the file " + file);
    }
}
