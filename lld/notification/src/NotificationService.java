import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/discuss/interview-question/object-oriented-design/488544/ood-notification-system
 */
public class NotificationService<T extends Notification> implements Subject<T> {
    private List<ObserverClazz> observerClazzList;
    public NotificationService(){
        this.observerClazzList = new ArrayList<>();
    }

    @Override
    public void attach(ObserverClazz observerClazz){
        observerClazzList.add(observerClazz);
    }

    @Override
    public void dettach(ObserverClazz observerClazz){
        observerClazzList.remove(observerClazz);
    }

    @Override
    public void notify(T t) {
        for(ObserverClazz observerClazz : observerClazzList){
            observerClazz.update(t);
        }
    }
}
