package eviction;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RandomEviction<T> implements CacheEviction {

    Set<T> evictionSet;

    public RandomEviction(){
         evictionSet=new HashSet<T>();
     }

    @Override
    public void put(Object key) {
        evictionSet.add((T)key);
    }

    @Override
    public void operationOnGet(Object key) {
       System.out.println("Random Eviction does not have any operation on get");
       return;
    }

    @Override
    public T evict() {
        T key =  evictionSet.stream().findFirst().get();
        if(key!=null){
            System.out.println("Evicting key " + key);
            evictionSet.remove(key);
        }
        return key;
    }
}
