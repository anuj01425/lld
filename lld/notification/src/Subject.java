import java.util.Observer;

public interface Subject<T> {
    void attach(ObserverClazz observerClazz);

    void dettach(ObserverClazz observerClazz);

    void notify(T t);
}
