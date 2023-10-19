/**
 * Edge 代表边的类
 */
public class Edge {

    Vertex linked; // 边指向的终点顶点
    int weight; // 边的权重

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}
