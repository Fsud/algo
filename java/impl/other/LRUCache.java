package impl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 借助LinkedHashMap的排序功能，accessOrder参数指定为true的情况下，最近访问的放在最后。
 * 而删除时，从前删除，从而实现了LRU
 */
public class LRUCache extends LinkedHashMap {

    private final int CACHE_SIZE;

    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }
}
