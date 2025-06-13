package HashMap;

import java.util.HashMap;

/** HashSet 底层就是一个 HashMap，其中键就是 Set 中的元素，值用一个占位符即可 */
public class MyHashSet<K> {
    // val 占位符
    private final static Object PRESENT = new Object();
    // 底层 HashMap
    private final HashMap<K, Object> map = new HashMap<>();

    public boolean add(K k) {
        return map.put(k, PRESENT) == null;
    }

    public boolean remove(K k) {
        return map.remove(k) == PRESENT;
    }

    public boolean contains(K k) {
        return map.containsKey(k);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}
