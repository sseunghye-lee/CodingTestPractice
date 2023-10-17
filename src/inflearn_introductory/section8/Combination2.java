package inflearn_introductory.section8;

import java.util.Scanner;

class Combination2 {
    static int[] comb;
    static int n, m;

    public void DFS(int L, int s) {
        if(L == m) {
            for(int x : comb) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                comb[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Combination2 T = new Combination2();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        comb = new int[m];
        T.DFS(0, 1);
    }
}
