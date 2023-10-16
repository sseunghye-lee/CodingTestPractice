package inflearn_introductory.section8;

import java.util.Scanner;

class MaxScore {
    static int answer = Integer.MIN_VALUE, n, m;
    boolean flag = false;
    public void DFS(int L, int sum, int time, int[] s, int[] t) {
        if(time > m) return;
        if(L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + s[L], time + t[L], s, t);
            DFS(L + 1, sum, time, s, t);
        }
    }

    public static void main(String[] args) {
        MaxScore T = new MaxScore();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
