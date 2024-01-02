package eviction;

public interface CacheEviction<T> {
    void put(T key);
    void operationOnGet(T key);
    T evict();
}
