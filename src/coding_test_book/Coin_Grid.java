package coding_test_book;

public class Coin_Grid {
    public static void main(String[] args) {
        int money = 1260;
        int cnt = 0;
        int[] coin = {500, 100, 50, 10};

        for(int i = 0; i < coin.length; i++) {
            cnt += money / coin[i];
            money %= coin[i];
        }
        System.out.println(cnt);
    }
}
