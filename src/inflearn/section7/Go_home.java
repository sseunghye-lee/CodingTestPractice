package inflearn.section7;
import java.util.*;
class Go_home {
    public int solution(int[] pool, int a, int b, int home){
        int[][] check = new int[2][10001];
        for(int p : pool) {
            check[0][p] = 1;
            check[1][p] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        check[0][0] = 1; // 놀이터
        check[1][0] = 1;

        queue.offer(new int[]{0, 0}); // 뒤 값이 0이면 앞으로 점프, 1이면 뒤로 점프
        int level = 0;

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                int[] current = queue.poll(); // (0,0)
                if(current[0] == home) return level;

                int nx = current[0] + a;
                if(nx <= 10001 && check[0][nx] == 0) {
                    check[0][nx] = 1;
                    queue.offer(new int[]{nx, 0});
                }
                nx = current[0] - b;
                if(nx >= 0 && check[1][nx] == 0 && current[1] == 0) { // 뒤로 점프는 두 번 못함
                    check[1][nx] = 1;
                    queue.offer(new int[]{nx, 1});
                }
            }
            level++;
        }
        return  -1;
    }

    public static void main(String[] args){
        Go_home T = new Go_home();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
