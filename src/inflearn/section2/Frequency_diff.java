package inflearn.section2;
import java.util.*;
class Frequency_diff {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char key : map.keySet()) {
            while(ch.contains(map.get(key))) {
                answer++;
                map.put(key, map.get(key) - 1);
            }
            if(map.get(key) == 0) continue;
            ch.add(map.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        Frequency_diff T = new Frequency_diff();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
