public class QuickFindDS {

    private int[] id;

    /* O(N) */
    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    
}
