package inflearn.section3;
import java.util.*;
class CPU {
    public int[] solution(int[][] tasks){
        int n = tasks.length;
        // int[] answer = new int[n]; // ArrayList 없이 할 수 있음(n의 크기가 클 경우)
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i}); // 작업 번호는 0번부터
        }
        programs.sort((a, b) -> a[0] - b[0]); // 호출시간에 의해 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int fT = 0;
        // int idx = 0;
        while(!programs.isEmpty() || !pq.isEmpty()) {
            if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= fT) {
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]}); // 실행시간, 작업번호
            }
            int[] ex = pq.poll();
            fT = fT + ex[0];
            res.add(ex[1]);
            // answer[idx++] = ex[1];
        }

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        CPU T = new CPU();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
