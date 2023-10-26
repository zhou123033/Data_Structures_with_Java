import java.util.List;

/**
 * 图的 Java 表示
 * Vertex 顶点
 */
public class Vertex {
    String name;
    List<Edge> edges;

    boolean visited; // 是否被访问过
    int inDegree; // 入度

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
