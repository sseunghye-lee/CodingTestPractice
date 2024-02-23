package inflearn.section3;
import java.util.*;
class MeetingRoom {
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] res = new int[n];
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i = 0; i < n; i++) rooms.add(i);
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int[] m : meetings) {
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) rooms.add(ends.poll()[1]); // 가장 빨리 끝나는 회의의 끝나는 시간 <= 배정해야할 회의 시작시간 -> 비어있는 회의실에 넣기
            if(!rooms.isEmpty()) {
                int room = rooms.pollFirst();
                res[room]++;
                ends.add(new int[]{m[1], room});
            } else {
                int[] e = ends.poll(); // 가장 빨리 끝나는 회의
                res[e[1]]++;
                ends.add(new int[]{e[0] + (m[1] - m[0]), e[1]}); // 현재 배정하려는 회의가 끝나는 시간
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(res[i] > max) {
                max = res[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        MeetingRoom T = new MeetingRoom();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
