package inflearn.section4;
import java.util.*;
class Min_meeting_room {
    public int solution(int[][] meetings){
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();

        for(int[] m : meetings) {
            list.add(new int[]{m[0], 1}); // 시작 시간
            list.add(new int[]{m[1], 2}); // 끝나는 시간
        }
        list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); // 시간 같으면 끝나는 시간 앞에 오도록 (내림차순)

        int cnt = 0;

        for(int[] l : list) {
            if(l[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Min_meeting_room T = new Min_meeting_room();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
