import datastore.InMemory;
import eviction.CacheEviction;
import eviction.RandomEviction;

public class Main {

    public static void main(String[] args) {
        CacheStore<String,String> cacheStore = new CacheStore<>(new InMemory(),new RandomEviction(),2);
        cacheStore.put("1","1");
        cacheStore.put("2","2");
        cacheStore.put("3","3");
        System.out.println(cacheStore.get("3"));
        cacheStore.put("4","4");
        System.out.println(cacheStore.get("2"));
    }
}