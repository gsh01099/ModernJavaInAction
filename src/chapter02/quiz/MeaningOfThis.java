package chapter02.quiz;

public class MeaningOfThis {
    public final int value = 4;

    public void doIn() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
}
