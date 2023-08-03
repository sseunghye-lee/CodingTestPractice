package inflearn.section7;

import java.util.*;
class Tile_jump {
    public int solution(int[] nums){
        int n = nums.length;
        int[] check = new int[n]; // 한 번 방문한 지점은 다시 큐에 넣지 않고 탐색하지 않음
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 시작지점
        check[0] = 1;
        int level = 0 ;

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                int x = queue.poll(); // level 노드의 값
                for(int j = 1; j <= nums[x]; j++) {
                    int child = x + j; // level+1 노드의 값
                    if(child == n - 1) return level + 1;
                    if(child < n && check[child] == 0) {
                        check[child] = 1;
                        queue.offer(child);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args){
        Tile_jump T = new Tile_jump();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
