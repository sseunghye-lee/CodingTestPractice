package inflearn.section8;
import java.util.*;
class Airplane {
    public int solution(int n, int[][] flights, int s, int e, int k){
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }
        int[] costs = new int[n];
        Arrays.fill(costs, 100000000);
        for(int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]}); // 0번에서 갈 수 있는 도시와 비용
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0}); // 출발 도시
        costs[s] = 0;
        int level = 0;

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                int[] p = queue.poll();
                int now = p[0];
                int nowCost = p[1]; // 출발 도시에서 now 도시까지 가는데 비용

                for(int[] x : graph.get(now)) { // 0번에서 갈 수 있는 도시들
                    int next = x[0];
                    int cost = x[1];

                    if(nowCost + cost < costs[next]) { // 출발에서 next 도시까지 가는 비용 < 최소비용
                        costs[next] = nowCost + cost;
                        queue.offer(new int[] {next, costs[next]}); // 갱신한 비용
                    }
                }
            }
            level++; // level이 3이면 2번 환승한 것
            if(level > k) break;
        }
        if(costs[e] == 100000000) return -1;
        else return costs[e];
    }

    public static void main(String[] args){
        Airplane T = new Airplane();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
