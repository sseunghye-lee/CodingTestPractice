package inflearn.section2;
import java.util.*;
class Frequency {
    public int[] solution(String s){
        int[] answer = new int[5];

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        String tmp = "abcde";
        for(char key : tmp.toCharArray()) {
            if(map.getOrDefault(key, 0) > max) { // map.get 하면 개수가 0인 문자를 가져올 수 없음 -> 없는 문자는 null이 돼서 에러 발생
                max = map.getOrDefault(key, 0);
            }
        }

        for(int i = 0; i < tmp.length(); i++) {
            answer[i] = max - map.getOrDefault(tmp.charAt(i), 0); // get 하면 마찬가지로 null이 됨
        }

        return answer;
    }

    public static void main(String[] args){
        Frequency T = new Frequency();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}

