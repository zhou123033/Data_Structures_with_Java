import java.util.LinkedList;

/**
 * 深度优先搜索 Depth-first search
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) { // 构造器
        marked = new boolean[G.V()];
    }
}
