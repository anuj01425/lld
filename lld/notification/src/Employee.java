import java.util.Observable;
import java.util.UUID;

public class Employee<T extends Notification> implements ObserverClazz<T> {

    private boolean isEligible;
    public String id;
    public String name;
    public String designation;

    public String notificationType;
    public String team;
    public String department;
    public Employee(String name,String designation,String team,String department){
        this.designation = designation;
        this.name=name;
        this.id = UUID.randomUUID().toString();
        this.isEligible=true;
        this.notificationType=null;
        this.team=team;
        this.department = department;

    }

    public void setEligible(boolean val){
        this.isEligible=val;
    }


    @Override
    public void update(T t) {
        if(isEligible && canReceiveNotification(t)){
             System.out.println("Employee with name " + this.name + " has received notifcaiton " + t.body);
        }
    }
    public boolean canReceiveNotification(T notification){
        if(notification.sender.equals(this.team) || notification.sender.equals("CEO") || notification.sender.equals(this.department)){
            return true;
        }
        return false;
    }

    @Override
    public void setNotificationType(String val) {
        this.notificationType=val;
    }
}
