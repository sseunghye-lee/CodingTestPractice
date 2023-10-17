package inflearn_introductory.section8;

import java.util.ArrayList;
import java.util.Scanner;

class Pizza {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] comb;
    static ArrayList<Point> pizza, house;

    public void DFS(int L, int s) {
        if(L == m) {
            int sum = 0;
            for(Point h : house) {
                int dis = Integer.MAX_VALUE;
                for(int i : comb) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = s; i < len; i++) {
                comb[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Pizza T = new Pizza();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pizza = new ArrayList<>();
        house = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if(tmp == 1) house.add(new Point(i, j));
                else if(tmp == 2) pizza.add(new Point(i, j));
            }
        }
        len = pizza.size(); // 피자집의 개수
        comb = new int[m]; // 피자집 조합 구해야함
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
