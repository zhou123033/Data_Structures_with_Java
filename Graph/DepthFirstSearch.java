package Graph;

import Graph.GraphADT;

/**
 * 深度优先搜索 Depth-first search
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(GraphADT G, int s) {  // 构造器
        marked = new boolean[G.V()];  // 数组长度为 G 的顶点数目
        dfs(G, s);
    }

    private void dfs(GraphADT G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
