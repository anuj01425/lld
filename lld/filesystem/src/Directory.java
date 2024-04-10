import java.util.ArrayList;
import java.util.List;

public class Directory implements Filesystem {
    public List<Filesystem> filesystemList;
    public String name;
    public Directory(String name){
        this.filesystemList = new ArrayList<>();
        this.name=name;
    }
    public void add(Filesystem filesystem){
        System.out.println("Adding in directory " + name);
        this.filesystemList.add(filesystem);
    }

    public void remove(Filesystem filesystem){
        System.out.println("Deleting in directory "+ name);
        this.filesystemList.remove(filesystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name is " + name);
        for(Filesystem filesystem : filesystemList){
            filesystem.ls();
        }
        System.out.println("*******");
    }
}
