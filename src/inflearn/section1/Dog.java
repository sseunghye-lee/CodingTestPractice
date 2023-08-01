package inflearn.section1;

class Dog {
    public int solution(int[][] board){
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
                if(board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        int d1 = 0;
        int d2 = 0;
        int cnt = 0;

        while(cnt < 10000) {
            cnt++;
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];
            boolean flag1 = true; // 매번 초기화 되어야함
            boolean flag2 = true;

            if(nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
                d1 = (d1 + 1) % 4;
                flag1 = false;
            }
            if(nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) {
                d2 = (d2 + 1) % 4;
                flag2 = false;
            }
            if(flag1) {
                x1 = nx1;
                y1 = ny1;
            }
            if(flag2) {
                x2 = nx2;
                y2 = ny2;
            }
            if(x1 == x2 && y1 == y2) break;
        }
        if(cnt >= 10000) return 0;

        return cnt;
    }

    public static void main(String[] args){
        Dog T = new Dog();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
