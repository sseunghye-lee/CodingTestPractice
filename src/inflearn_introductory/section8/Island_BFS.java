package inflearn_introductory.section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Island_BFS {
    static int answer = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>();

    public void BFS(int x, int y, int[][] board) {
        queue.add(new Point(x, y));
        while(!queue.isEmpty()) {
            Point pos = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board) {
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0; // 출발점을 바다로 바꿔놓고 시작
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Island_BFS T = new Island_BFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
