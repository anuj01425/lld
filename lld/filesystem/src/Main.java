public class Main {

    //Composite design pattern is use to implement the problem which can be represented in the form of tree
    //In the file system case the leaf can be file and branch can be directory
    //Each leaf and branch needs to implement a common interface (composite)
    //the branch needs to have a function which can add a new branch (can be branch or leaf)
    public static void main(String[] args) {

        Directory music = new Directory("Music directory");
        Directory arjith = new Directory("Arjith");

        File file1 = new File("arjith1.mp4");
        File file2 = new File("arjith2.mp4");
        arjith.add(file2);
        arjith.add(file1);
        music.add(arjith);

        Directory shreya = new Directory("Shreya");
        File file3 = new File("shreya1.mp4");
        File file4 = new File("shreya2.mp4");
        shreya.add(file3);
        shreya.add(file3);
        music.add(shreya);

        music.ls();

    }
}