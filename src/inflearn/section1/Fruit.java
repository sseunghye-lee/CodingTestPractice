package inflearn.section1;

class Fruit {

    public int getMin(int[] fruit) {
        int min = 100;

        for(int f : fruit) {
            min = Math.min(min, f);
        }
        return min;
    }

    public Boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);

        for(int f : fruit) {
            if(f == min) cnt++;
        }

        if(cnt == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int getMinIndex(int[] fruit) {
        int min = getMin(fruit);

        for(int i = 0; i < 3; i++) {
            if(fruit[i] == min) return i;
        }
        return 0;
    }
    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] check = new int[n];

        for(int i = 0; i < n; i++) {
            if(check[i] == 1) continue; // 이미 교환함

            if(isMinUnique(fruit[i]) == false) continue;

            for(int j = i + 1; j < n; j++) {
                if(check[j] == 1) continue;

                if(isMinUnique(fruit[j]) == false) continue;

                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);

                if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if(fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][a]--;
                        fruit[j][b]++;

                        check[i] = 1;
                        check[j] = 1;
                        break; // 최초의 교환할 학생 만나면 멈추고 반복하지 않아도 됨.
                    }
                }
            }
        }
        for(int[] f : fruit) {
            answer += getMin(f);
        }

        return answer;
    }

    public static void main(String[] args){
        Fruit T = new Fruit();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
