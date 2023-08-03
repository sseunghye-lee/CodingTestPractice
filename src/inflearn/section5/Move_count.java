package inflearn.section5;
import java.util.*;
class Move_count {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            if(nums[left] + nums[right] <= 5) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Move_count T = new Move_count();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
