package inflearn.section4;
import java.util.*;
class BinaryNumber {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        int[][] result = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++) {
            int cnt = 0;
            int tmp = nums[i];

            while(tmp > 0) {
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }

            result[i][0] = nums[i];
            result[i][1] = cnt;
        }
        Arrays.sort(result, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for(int i = 0; i < result.length; i++) {
            answer[i] = result[i][0];
        }

        return answer;
    }

    public static void main(String[] args){
        BinaryNumber T = new BinaryNumber();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
