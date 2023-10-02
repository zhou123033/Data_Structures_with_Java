import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {

    private int[] id;   // 分量id (以触点作为索引)
    private int count;  // 分量数量

    public UF(int N) {
        // 初始化分量 id 数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {

    }

    public void union(int p, int q) {

    }

    public static void main(String[] args) {
        // 解决由 StdIn 得到的动态连通性问题
        int N = StdIn.readInt(); // 读取触点数量
        UF uf = new UF(N);       // 初始化 N 个分量
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();  // 读取整数对
            if (uf.connected(p, q)) {
                continue; // 如果已经连通则忽略
            }
            uf.union(p, q); // 归并分量
            StdOut.println(p + " " + q); // 打印连接
        }
        StdOut.println(uf.count() + "components");
    }
}
