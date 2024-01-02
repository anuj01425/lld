package datastore;

public interface DataStore<K,V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    int size();
    boolean containsKey(K key);
}
