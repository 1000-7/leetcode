package company.bytedance.datastucture;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache{

    private LRU cache;

    public LRUCache(int capacity) {
        this.cache = new LRU(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key))
            return cache.get(key);
        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    class LRU extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRU(int capacity) {
            // 注意，需要开启 ordering mode，此时若元素被访问（put、get）就会被移到链表尾
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        /**
         * removeEldestEntry方法会在插入元素之后调用，用以判断是否需要移除链表表头元素（最近最少访问元素）
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > capacity;
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(1));

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
}


