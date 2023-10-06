package inflearn_introductory.section1;

import java.util.Scanner;

class Find_Character {
    public int solution(String str, char c) {
        int answer = 0;

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

//        for(int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == c) answer++;
//        }

        // string을 기반으로 string에 문자 하나하나를 분리하여 문자 배열을 생성
        for(char x : str.toCharArray()) {
            if(x == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Find_Character T = new Find_Character();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0); // string에 index로 접근

        System.out.println(T.solution(str, c));
    }
}
