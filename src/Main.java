import java.util.*;


public class Main {

    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;
        int[] ch = new int[n];

        for(int i = 0; i < n; i++) {
            for(int x : routes[i]) {
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int L = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int cur = queue.poll();
                for(int line : graph.get(cur)) {
                    if(ch[line] == 1) continue;
                    ch[line] = 1;
                    for(int r : routes[line]) {
                        if(r == e) return L;
                        queue.offer(r);
                    }
                }
            }
            L++;
        }

        return -1;
    }


    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}