package company.bytedance.datastucture;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCacheOrderFalse {
    // 用来装item的LinkedHashMap子类对象
    CacheMap cache;

    public LRUCacheOrderFalse(int capacity) {
        cache = new CacheMap(capacity);
    }

    class CacheMap extends LinkedHashMap<Integer, Integer> {
        private int max;

        CacheMap(int max) {
            this.max = max;
        }

        @Override
        protected boolean removeEldestEntry(HashMap.Entry<Integer, Integer> eldest) {
            return size() > max;
        }
    }

    /**
     * 每次get容器中的值，都将相应元素删除重新插入，这时它就会位于最新的位置
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCacheOrderFalse cache = new LRUCacheOrderFalse(2);
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

