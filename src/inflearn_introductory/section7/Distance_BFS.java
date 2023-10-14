package inflearn_introductory.section7;

import java.util.LinkedList;
import java.util.Queue;

public class Distance_BFS {
    Node root;

    public int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0; i < length; i++) {
                Node cur = queue.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String args[]) {
        Distance_BFS tree = new Distance_BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
