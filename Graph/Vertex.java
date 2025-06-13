package Graph;

import java.util.List;

/**
 * 图的 Java 表示
 * Vertex 顶点
 */
public class Vertex {
    String name;
    List<Edge> edges;

    boolean visited; // 是否被访问过，用在 BFS 和 DFS
    int inDegree; // 入度，用在拓扑排序
    int status; // 状态 0-未访问 1-访问中 2-访问过，用在拓扑排序

    int dist = INF; // 距离
    static final Integer INF = Integer.MAX_VALUE; // 初始化默认无穷大
    Vertex prev = null; // 记录路径，从哪个点来的

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
