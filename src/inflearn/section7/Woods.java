package inflearn.section7;

import java.util.*;
class Woods {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -2};
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2 || board[i][j] == 3) {
                    queue.offer(new int[]{i, j});
                    int[][] check = new int[n][m];
                    check[i][j] = 1;
                    int level = 0;

                    while(!queue.isEmpty()) {
                        level++;
                        int length = queue.size();
                        for(int r = 0; r < length; r++) {
                            int[] current = queue.poll();
                            for(int k = 0; k < 4; k++) {
                                int nx = current[0] + dx[k];
                                int ny = current[1] + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) {
                                    if(check[nx][ny] == 0) {
                                        check[nx][ny] = 1;
                                        dist[nx][ny] += level;
                                        queue.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 4 && dist[i][j] > 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Woods T = new Woods();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
