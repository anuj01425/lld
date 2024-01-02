import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public class Node {
        public int data;
        public Node prev;
        public Node next;
        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }

    }
    private Map<Integer, Node> evictionPolicyMap;
    private Map<Integer,Integer> dataStoreMap;
    private Integer capacity;
    private Node head;
    private Node tail;
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.head=null;
        this.tail=null;
        this.evictionPolicyMap=new HashMap<>();
        this.dataStoreMap=new HashMap<>();
    }
    private void removeNode(Node node){
        LRUCache.Node prev=node.prev;
        LRUCache.Node next = node.next;
        if(prev != null){
            prev.next=next;
        }
        else {
            head=next;
        }
        if(next !=null){
            next.prev=prev;
        }
        else {
            tail=prev;
        }
    }

    private void addToFront(Node node){
        node.next=head;
        node.prev=null;
        if(head == null){
            tail=node;
        }
        else {
            head.prev=node;
        }
        head=node;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addToFront(node);
    }

    public int get(int key) {
        if(dataStoreMap.containsKey(key)){
            moveToHead(evictionPolicyMap.get(key));
            return dataStoreMap.get(key);
        }
        return -1;
    }

    public void put(int key,int value) {
        if(dataStoreMap.containsKey(key)){
            dataStoreMap.put(key,value);
            moveToHead(evictionPolicyMap.get(key));
            return ;
        }
        Node node = new Node(key);
        if(dataStoreMap.size() == capacity){
            evictionPolicyMap.remove(tail.data);
            dataStoreMap.remove(tail.data);
            removeNode(tail);
        }
        evictionPolicyMap.put(key,node);
        dataStoreMap.put(key,value);
        addToFront(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    /**
     *  1.There will be 2 maps. One to store cache eviction status and another to store underline data.
     *  Cache eviction Map can have key and node as value. Data store map can have key and value as value.
     *  We are going to create a doubly linked list with always having information of head and tail. head will have
     *  latest data and tail will have oldest data.
     *  2. In case of get , we have to check if the key exist in eviction map. If not , then it doesn't exist. If yes,
     *   we can return the data through data store map. Operation need to performed is we need to move this
     *   node to head of the linked list.
     *  3.In case of put, check if there is update operation through if key exists in eviction map. If yes,
     *   then we need to update the value in data store map and move the node to head of the linked list.
     *   If not, we can check if the map size is equal to capacity. If yes, we need to remove the tail and update
     *   the map (eviction and data store). After that we can add the new node in front of linked list and update
     *   both the map.
     *   Same can be done if the map size is less than capacity. Insert in map and add to front of list.
     *  3.Removal of node from list
     *    Think first for the node.prev. Don't mix it up with node.next. Try to handle both of the cases.
     *    After that think of node.next.
     *  4. Add to front of the lists
     *    In this case image as a simple case where the double link list exist and associate the new node.
     *    Now check for the condition if node empty. Try to keep it simple
     *
     *
     */
}