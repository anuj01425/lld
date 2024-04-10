import javax.xml.namespace.QName;

public class File implements Filesystem{
    public String name;
    public File(String name){
        this.name = name;
    }
    @Override
    public void ls() {
        System.out.println("Name of the file is " + name);
    }
}
