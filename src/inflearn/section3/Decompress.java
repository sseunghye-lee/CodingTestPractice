package inflearn.section3;
import java.util.*;
class Decompress {
    public String solution(String s){
        String answer = "";
        Stack<String> str = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == ')') {
                String tmp = "";
                while(!str.empty()) {
                    String out = str.pop();
                    if(out.equals("(")) {
                        String num = "";
                         while(!str.empty() && Character.isDigit(str.peek().charAt(0))) {
                             num = str.pop() + num;
                         }
                         String result = "";
                         int cnt = 0;

                         if(num.equals("")) cnt = 1;
                         else cnt = Integer.parseInt(num);

                         for(int i = 0; i < cnt; i++)
                             result += tmp;

                         str.push(result);
                         break;
                    }
                    tmp = out + tmp;
                }
            }
            else str.push(String.valueOf(c));
        }

        for(String st : str)
            answer += st;

        return answer;
    }

    public static void main(String[] args){
        Decompress T = new Decompress();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
