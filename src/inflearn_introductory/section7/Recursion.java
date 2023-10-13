package inflearn_introductory.section7;

class Recursion {
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args) {
        Recursion T = new Recursion();
        T.DFS(3);

    }
}
