import java.util.ArrayList;
import java.util.Arrays;

/**
 * 哈希表
 * 给每份数据分配一个编号，放入表格(数组)
 * 建立编号与表格索引的关系，将来就可以通过编号快速查找数据
 * 1. 理想情况编号当唯一，表格能容纳所有数据
 * 2. 现实是不能说为了容纳所有数据造一个超大表格，编号也有可能重复
 * 解决
 * 1. 有限长度的数组，以 拉链 方式存储数据
 * 2. 允许编号适当重复，通过数据自身来进行区分
 */
public class HashTable {
    // 节点类
    static class Entry {
        int hash; // 哈希码
        Object key; // 键
        Object value; // 值
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    Entry[] table = new Entry[16];
    int size = 0; // 元素个数
    float loadFactor = 0.75f; // 哈希表的负载因子
    int threshold = (int) (loadFactor * table.length); // 12 阈值

    /* 求模运算替换为位运算
        - 前提：数组长度是 2 的 n 次方
        - hash % 数组长度 等价于 hash & (数组长度-1)
     */

    // 根据 hash 码获取 value
    Object get(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry p = table[idx]; // 拿到链表头节点，开始遍历
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    // 向 hash 表存入新 key value，如果 key 重复，则更新 value
    void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 1. idx 处有空位，直接新增
            table[idx] = new Entry(hash, key, value);
            size++;
        } else {
            // 2. idx 处无空位，沿链表查找 有重复key更新，否则新增
            Entry p = table[idx];
            while (true) {
                if (p.key.equals(key)) {
                    p.value = value; // 更新
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value); // 新增
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    private void resize() {
        Entry[] newTable = new Entry[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i]; // 拿到每个链表头
            if (p != null) {
                // 拆分链表，移动到新数组
                /*
                    拆分规律
                    * 一个链表最多拆成两个
                    * hash & table.length == 0 的一组
                    * hash & table.length != 0 的一组
                 */
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    if ((p.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;
                        }
                        // 分配到 a
                        a = p;
                    } else {
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;
                        }
                        // 分配到 b
                        b = p;
                    }
                    p = p.next;
                }
                // 规律：a 链表保持索引位置不变，b 链表索引位置+table.length
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i+table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

    // 根据 hash 码删除，返回删除的 value
    Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry p = table[idx];
        Entry prev = null;
        while(p != null) {
            if (p.key.equals(key)) {
                // 找到了，进行删除
                if (prev == null) {
                    table[idx] = p.next;
                } else {
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }
        return null;
    }

    public Object get(Object key) {
        int hash = hash(key);
        return get(hash, key);
    }

    public void put(Object key, Object value) {
        int hash = hash(key);
        put(hash, key, value);
    }

    public Object remove(Object key) {
        int hash = hash(key);
        return remove(hash, key);
    }

    private static int hash(Object key) {
        return key.hashCode();
    }

    public void print() {
        int[] sums = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            int sum = 0;
            while(p != null) {
                sums[i]++;
                p = p.next;
            }
        }
        System.out.println(Arrays.toString(sums));
    }
}

