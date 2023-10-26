import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Vertex> graph = new ArrayList<>();
        // 1. 统计每个顶点的入度
        for (Vertex v: graph) {
            for (Edge edge : v.edges) {
                edge.linked.inDegree++;
            }
        }
        // 2. 将入度为0的顶点加入队列
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex v : graph) {
            if (v.inDegree == 0) {
                queue.offer(v);
            }
        }
        // 3. 队列中不断移除顶点，每移除一个顶点，把它相邻顶点入度减1，若减到0则入队
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                edge.linked.inDegree++;
                if (edge.linked.inDegree == 0) {
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
