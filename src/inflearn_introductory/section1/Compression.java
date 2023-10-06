package inflearn_introductory.section1;

import java.util.Scanner;

class Compression {
    public String solution(String str) {
        String answer = "";
        str = str + ""; // 빈 문자 하나 더하기
        int cnt = 1;

        for(int i = 0; i < str.length() - 1; i++) { // 빈 문자를 하나 더했기 때문에 length - 1까지만 돌아야함
            if(str.charAt(i) == str.charAt(i + 1)) cnt++;
            else {
                answer += str.charAt(i);
                if(cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Compression T = new Compression();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
