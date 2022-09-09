package chapter05.practice;

import java.util.Arrays;
import java.util.List;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    /**
     * 거래자(Trader) 리스트와 트랜잭션(Transaction)리스트
     */
    private static Trader raoul = new Trader("Raoul","Cambridge");
    private static Trader mario = new Trader("Mario","Milan");
    private static Trader alan = new Trader("Alan","Cambridge");
    private static Trader brian = new Trader("Brian","Cambridge");

    public static List<Transaction> transactions = Arrays.asList(
      new Transaction(brian, 2011,300),
      new Transaction(raoul, 2012,1000),
      new Transaction(raoul, 2011,400),
      new Transaction(mario, 2012,710),
      new Transaction(mario, 2012,700),
      new Transaction(alan, 2012,950)
    );

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
