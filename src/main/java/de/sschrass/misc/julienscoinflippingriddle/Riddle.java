package de.sschrass.misc.julienscoinflippingriddle;
/*
 * You have a row of 1000 coins, all on heads.
 * You take every other coin & flip it over: the 2nd coin, 4th coin, 6th coin, etc.
 * Do the same with every third coin: the 3rd one, the 6th (again), the 9th...
 * And so on & so forth, until you flip every 1000th coin (so just the last one).

 * Question: which coins are on heads at the end?
 */
public class Riddle {
    private static Coin[] coins;

    public static void main(String[] args) {
        int capacity = 100;
        initCoins(capacity);
        checkCoins(capacity);
        printCoins(capacity);
        printFlipCounts(capacity);
        printEvenFlipCounts(capacity);
    }

    private static void printEvenFlipCounts(int capacity) {
        for (int i = 0; i < capacity; i++) {
            if (coins[i].getFlipCount() % 2 == 0) {
                System.out.println((i+1));
            }
        }
    }

    private static void printFlipCounts(int capacity) {
        for (int i = 0; i < capacity; i++) {
            System.out.println((i+1) + ": " + coins[i].getFlipCount());
        }
    }

    private static void printCoins(int capacity) {
        String result = "";
        for (int i = 0; i < capacity; i++) {
            if (coins[i].getCoinState().equals(CoinState.HEAD)) {
                result += i + 1 + ", ";
            }
        }
        System.out.println(result);
    }

    private static void checkCoins(int capacity) {
        for (int i = 0; i < capacity; i++) {
            if (i != 0) {
                for (int j = i; j < capacity; j++) {
                    if ((j+1) % (i+1) == 0) { coins[j].flip(); }
                }
            }
        }
    }

    private static void initCoins(int capacity) {
        coins = new Coin[capacity];
        for (int i = 0; i < capacity; i++) {
            coins[i] = new Coin(CoinState.HEAD);
        }
    }
}
