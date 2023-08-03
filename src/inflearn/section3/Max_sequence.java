package inflearn.section3;

import java.util.*;
class Max_sequence {
    public int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) set.add(n);
        for(int n : set) {
            if(set.contains(n - 1)) continue; // 1만큼 작은 숫자가 존재하면 수열의 시작 숫자가 될 수 없음
            int cnt = 0;
            while(set.contains(n)) {
                cnt++;
                n++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Max_sequence T = new Max_sequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
