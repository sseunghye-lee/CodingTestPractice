package inflearn_introductory.section9;

import java.util.Scanner;

class Friends {
    static int[] unf;
    public static int Find(int v) {
        if(v == unf[v]) return v; // 집합번호 리턴
        else return unf[v] = Find(unf[v]); // 경로압축
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for(int i = 1; i <= n; i++) unf[i] = i;
        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b); // a와 b를 친구관계로 만들어라
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
