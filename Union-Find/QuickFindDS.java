/**
 * CS61B
 * The indices of the array represent the elements of our set.
 * The value at an index is the set number it belongs to.
 */
public class QuickFindDS implements DisjointSets {

    private int[] id;

    /* O(N) */
    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /* need to iterate through the array => O(N) */
    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /* O(1) */
    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
