package datastore;

import java.util.HashMap;

public class InMemory<K,V> implements DataStore {
    private HashMap<K,V> dataStore;

    public InMemory() {
        this.dataStore=new HashMap<>();
    }

    @Override
    public void put(Object key, Object value) {
        System.out.println("Putting key " + key + " value " + value  + " in InMemory DataStore");
        dataStore.put((K) key,(V) value);
    }

    @Override
    public V get(Object key) {
        System.out.println("Getting key " + key + " from InMemory DataStore");
        return dataStore.get(key);
    }

    @Override
    public void remove(Object key) {
        System.out.println("Removing key " + key + " from InMemory DataStore");
        this.dataStore.remove(key);
    }

    @Override
    public int size() {
        System.out.println("Current InMemory Datastore size is " +this.dataStore.size());
        return this.dataStore.size();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.dataStore.containsKey(key);
    }
}
