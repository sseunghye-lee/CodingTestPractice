package inflearn_introductory.section7;

import java.util.Scanner;

class Route_DFS {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0; // back 했을 때 체크한 것 풀어주기
                }
            }
        }

    }

    public static void main(String[] args) {
        Route_DFS T = new Route_DFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간선 개수
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
