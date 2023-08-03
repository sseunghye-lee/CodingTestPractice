package inflearn.section2;

import java.util.HashMap;

class FirstMessage {
    public int solution(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1); // 문자열 빈도수 카운팅
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        FirstMessage T = new FirstMessage();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
