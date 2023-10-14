/**
 * 基于堆的优先队列 (MaxHeap Priority Queue)
 */
@SuppressWarnings("all")
public class MaxPQ<Key extends Comparable<Key>> {

    // 存储元素的数组
    private Key[] pq;   // 基于堆的完全二叉树
    // 当前 Priority Queue 中的元素个数
    private int N = 0;  // 存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[maxN+1];
    }

    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /* 插入元素 */
    public void insert(Key v) {
        N++;
        // 先把新元素添加到最后
        pq[N] = v;
        // 然后让它上浮到正确的位置
        swim(N);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        // maxHeap的堆顶就是最大元素
        Key max = pq[1];  // 从根节点得到最大元素
        // 把这个最大元素换到最后，并删除
        exch(1, N);   // 将其和最后一个节点交换
        N--;
        pq[N+1] = null;   // 防治对象游离
        // 让 pq[1] 下沉到正确位置
        sink(1);       // 恢复堆的有序性
        return max;
    }

    /** 堆实现的比较方法 */
    private boolean less(int i, int j) { // pq[i] 是否比 pq[j] 小？
        return pq[i].compareTo(pq[j]) < 0;
    }

    /** 堆实现的交换方法 */
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /** 堆有序化的上浮方法 */
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k > 1 && less(k/2, k)) {
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            exch(k/2, k);
            k = k/2;
        }
    }

    /** 堆有序化的下沉方法 */
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (2*k <= N) {
            int j = 2*k; // 先假设左边节点较大，得到 j 为左子节点索引
            if (j < N && less(j, j+1)) j++; // 如果右边节点存在，比一下大小，更新 j 指向较大者
            if (!less(k, j)) break; // 节点 k 比两孩子都大，就不必下沉了
            exch(k, j); // 否则，不符合堆结构，下沉 k
            k = j;
        }
    }
}
