package inflearn.section6;
import java.util.*;
class Tug_of_war {

    int[] check;
    int[][] relation;
    int answer;
    Stack<Integer> stack;

    public void DFS(int L) {
        if(L == 7) answer++;
        else {
            for(int i = 1; i < 8; i++) {
                if(!stack.empty() && relation[stack.peek()][i] == 1) continue; // 바로 앞에 세웠던 학생과 세우려는 학생
                if(check[i] == 0) {
                    check[i] = 1;
                    stack.push(i);
                    DFS(L + 1);
                    check[i] = 0;
                    stack.pop(); // back을 하게 되면 넣었던 것 빼기
                }
            }
        }
    }
    public int solution(int[][] fight){
        answer = 0;
        stack = new Stack<>();
        relation = new int[8][8];

        for(int[] f : fight) {
            relation[f[0]][f[1]] = 1;
            relation[f[1]][f[0]] = 1;
        }

        check = new int[8];
        DFS(0);

        return answer;
    }

    public static void main(String[] args){
        Tug_of_war T = new Tug_of_war();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}

