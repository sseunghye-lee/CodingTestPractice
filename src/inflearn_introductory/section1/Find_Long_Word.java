package inflearn_introductory.section1;

import java.util.Scanner;

class Find_Long_Word {
    public String solution(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE, pos;

        /* 1번째 방법
        String[] s = str.split(" ");
        for(String x : s) {
            int len = x.length();
            if(len > max) {
                max = len;
                answer = x;
            }
        }
         */

        // 2번째 방법
        while((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        if(str.length() > max) answer = str; // 마지막 단어 뒤에는 공백이 없기 때문에 마지막 남은 단어 처리를 따로 꼭 해줘야함

        return answer;
    }

    public static void main(String[] args) {
        Find_Long_Word T = new Find_Long_Word();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
