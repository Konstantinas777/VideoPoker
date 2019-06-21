

public class PokerCash {
    public static int money = 50;

    public int minusEuro(int n) {
        money = n - money;
        return money;
    }


    public static int addEuro(int n) {
        money = n + money;
        return money;
    }

}
