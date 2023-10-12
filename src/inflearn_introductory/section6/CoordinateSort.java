package inflearn_introductory.section6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y; // 정렬을 하기 위해서는 음수가 되도록 리턴
        else return this.x - o.x;
    }
}
class CoordinateSort {
    public int solution(int n) {
        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        CoordinateSort T = new CoordinateSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x + " " + o.y);
    }
}
