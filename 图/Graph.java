import edu.princeton.cs.algs4.In;

/**
 * 图的数据结构 API 实现 - 邻接表
 * 我们使用一个以顶点为索引的链表数组，其中的每个元素都是和该顶点相邻的顶点组成的链表，
 * 该数组将每个顶点的所有相邻顶点都保存在该顶点对应的元素所指向的一张链表中
 */
public class Graph {

    private final int V;        // 顶点数目
    private int E;              // 边的数目
    private Bag<Integer>[] adj; // 邻接表
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // 创建邻接表
        for (int v = 0; v < V; v++) {      // 将所有链表初始化为空
            adj[v] = new Bag<Integer>();
        }
    }
    public Graph(In in) {
        this(in.readInt());   // 读取 V 并将图初始化
        int E = in.readInt(); // 读取 E
        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt(); // 读取一个顶点
            int w = in.readInt(); // 读取另一个顶点
            addEdge(v, w);        // 添加一条连接它们的边
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public void addEdge(int v, int w) {
        adj[v].add(w);  // 将 w 添加到 v 的链表中
        adj[w].add(v);  // 将 v 添加到 w 的链表中
        E++;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
