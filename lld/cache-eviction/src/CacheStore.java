import datastore.DataStore;
import eviction.CacheEviction;

public class CacheStore<K,V> {
    private DataStore<K,V> dataStore;
    private CacheEviction<K> cacheEviction;
    private int capacity;

    public CacheStore(DataStore<K,V> dataStore, CacheEviction<K> cacheEviction,int capacity){
        this.dataStore = dataStore;
        this.cacheEviction = cacheEviction;
        this.capacity=capacity;
    }

    public void put(K key, V value) {
        if(dataStore.containsKey(key)){
            cacheEviction.operationOnGet(key);
            dataStore.put(key,value);
            return;
        }
        int dataStoreSize = dataStore.size();
        if(dataStoreSize == capacity) {
            K evictedKey = cacheEviction.evict();
            dataStore.remove(evictedKey);
        }
        dataStore.put(key,value);
        cacheEviction.put(key);
    }
    public V get(K key) {
        V value = dataStore.get(key);
        cacheEviction.operationOnGet(key);
        return value;
    }
}
