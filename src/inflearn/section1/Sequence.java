package inflearn.section1;

import java.util.ArrayList;

class Sequence {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();

        for(int i = 1; i < n - 1; i++) { // 양 끝은 봉우리가 아님
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peaks.add(i);
            }
        }

        for(int p : peaks) {
            int left = p;
            int right = p;
            int cnt = 1;

            while(left - 1 >= 0 && nums[left - 1] < nums[left]) {
                left--;
                cnt++;
            }
            while(right + 1 < n && nums[right] > nums[right + 1]) {
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Sequence T = new Sequence();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
