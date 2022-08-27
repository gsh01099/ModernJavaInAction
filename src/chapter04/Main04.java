package chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main04 {
    public static void main(String[] args) {
        DishService.스트림설명기반예제();

        // 스트림은 단 한번만 소비 할 수있다는 점을 명심하자 !!!!!
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();

        s.forEach(System.out::println); // title의 각 단어를 출력
        try {
            s.forEach(System.out::println); // java.lang.IllegalStateException : 스트림이 이미 소비되었거나 닫힘
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 학습용 스트림
        DishService.학습용스트림();
    }
}
