import java.util.Arrays;

/**
 * Disjoint Set 并查集
 */
public class DisjointSet {
    int[] s;

    public DisjointSet(int size) {
        s = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = i;
        }
    }

    public int find(int x) {
        return x;
    }

    public void union(int x, int y) {

    }

    public String toString() {
        return Arrays.toString(s);
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);
        System.out.println(set);
        // 索引对应顶点
        // 元素是用来表示与之有关系的顶点
        
    }
}
