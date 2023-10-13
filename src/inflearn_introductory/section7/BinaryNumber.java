package inflearn_introductory.section7;

class BinaryNumber {
    public void DFS(int n) {
    if(n == 0) return;
    else {
        DFS(n / 2);
        System.out.print(n % 2 + " ");
    }

}

    public static void main(String[] args) {
        BinaryNumber T = new BinaryNumber();
        T.DFS(11);
    }
}
