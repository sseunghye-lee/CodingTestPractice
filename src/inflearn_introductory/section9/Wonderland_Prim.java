package inflearn_introductory.section9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class EdgePrim implements Comparable<EdgePrim> {
    public int vex;
    public int cost;

    EdgePrim(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(EdgePrim o) {
        return this.cost - o.cost;
    }
}

class Wonderland_Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<EdgePrim>> graph = new ArrayList<ArrayList<EdgePrim>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<EdgePrim>());
        }
        int[] ch = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new EdgePrim(b, c));
            graph.get(b).add(new EdgePrim(a, c));
        }
        int answer = 0;
        PriorityQueue<EdgePrim> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new EdgePrim(1, 0));
        while(!priorityQueue.isEmpty()) {
            EdgePrim tmp = priorityQueue.poll();
            int endVex = tmp.vex;;
            if(ch[endVex] == 0) { // 회로가 되는 것을 방지함
                ch[endVex] = 1;
                answer += tmp.cost;
                for(EdgePrim o : graph.get(endVex)) {
                    if(ch[o.vex] == 0) priorityQueue.offer(new EdgePrim(o.vex, o.cost)); // 이미 포함된 것은 넣지 않겠다
                }
            }
        }
        System.out.println(answer);
    }
}
