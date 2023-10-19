import java.util.LinkedList;

/**
 * 广度优先搜索 Breadth-first search
 */
public class BFS {
    private static void bfs(Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(v);
        v.visited = true;
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
