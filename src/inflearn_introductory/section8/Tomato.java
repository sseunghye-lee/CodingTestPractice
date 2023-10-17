package inflearn_introductory.section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> queue = new LinkedList<>();

    public void BFS() {
        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Tomato T = new Tomato();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) queue.offer(new Point(i, j)); // 익은 토마토 큐에 넣기
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 0) flag = false;
            }
        }
        if(flag) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}
