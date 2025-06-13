package Graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
  public static void main(String[] args) {

  }

  private static void dijkstra(List<Vertex> graph, Vertex source) {
    PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));
    source.dist = 0;
    for (Vertex v : graph) {
      queue.offer(v);
    }

    while (!queue.isEmpty()) {
      // 3. 选取当前顶点
      Vertex curr = queue.peek();
      // 4. 更新当前顶点邻居距离
      if (!curr.visited) {
        updateNeighboursDist(curr, queue);
        curr.visited = true;
      }
      // 5. 移除当前顶点
      queue.poll();
    }

    for (Vertex v : graph) {
      System.out.println(v.name + " " + v.dist + " " + (v.prev != null ? v.prev.name : "null"));
    }
  }

  private static void updateNeighboursDist(Vertex curr, PriorityQueue<Vertex> queue) {
    for (Edge edge : curr.edges) { // 当前节点的邻居节点
      Vertex n = edge.linked;
      if (!n.visited) {
        int dist = curr.dist + edge.weight;
        if (dist < n.dist) { // 边的松弛
          n.dist = dist;
          n.prev = curr;
          queue.offer(n);
        }
      }
    }
  }

//  private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
//    Vertex min = list.get(0);
//    for (int i = 1; i < list.size(); i++) {
//      if (list.get(i).dist < min.dist) {
//        min = list.get(i);
//      }
//    }
//    return min;
//  }
}
