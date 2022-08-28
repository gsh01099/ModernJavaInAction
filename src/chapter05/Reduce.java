package chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // for-each를 이용한 숫자 합
    public static void forEach를이용한숫자합() {
        int sum = 0;

        for (int x : numbers) {
            sum += x;
        }
    }

    // reduce 사용
    public static void reduce사용() {
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        int sum2 = numbers.stream().reduce(0, Integer::sum);

        // 초기값 없음
        Optional<Integer> sum3 = numbers.stream().reduce((a,b) -> a * b);
        Optional<Integer> sum4 = numbers.stream().reduce(Integer::sum);
    }

    // min max
    public static void 최댓값최솟값() {
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
    }
}
