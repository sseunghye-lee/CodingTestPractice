package inflearn.section1;
import java.util.*;
class Seat {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if(k > c * r) return new int[] {0, 0}; // 총 좌석의 개수보다 k가 크면 (0,0) 반환
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int cnt = 1;
        int d = 1; // 3시 방향 이동

        while(cnt < k) {
            int nx = x + dx[d]; // nx, ny는 x,y보다 한 칸 앞서 있는 자리
            int ny = y + dy[d];

            if(nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = cnt;
            cnt++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1; // 처음 0행 0열로 시작했으니 1씩 더해줘야함
        answer[1] = y + 1;

        return answer;
    }

    public static void main(String[] args){
        Seat T = new Seat();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
