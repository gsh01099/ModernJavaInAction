package chapter05;

import chapter04.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStream {

    // reduce 메서드로 스트림 요소의 합을 구하는 예제
    public static int 요리의합계() {
        return Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
    }

    // 기본형 특화 스트림
    public static int 기본형특화스트림() {
        return Dish.menu.stream()   // Stream<Dish>반환>
                .mapToInt(Dish::getCalories)    // IntStream 반환
                .sum();
    }

    // 기본형 특화 스트림을 일반 스트림으로 변환
    public static void 특화스트림을일반스트링으로변환() {
        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories); // 스트림을 숫자 스트림으로 변환
        Stream<Integer> stream = intStream.boxed(); // 숫자 스트림을 스트림으로 변환
    }

    // OptionalInt 활용
    public static OptionalInt OptionalInt활용() {
        OptionalInt maxCalories =
                Dish.menu.stream()
                        .mapToInt(Dish::getCalories)
                        .max();
        int max = maxCalories.orElse(1); // 값이 없을 때 기본 최댓값을 명시적으로 설정
        return maxCalories;
    }

    // 숫자범위확인메서드
    public static void 숫자범위확인메서드() {
        IntStream evenNumbers1 = IntStream.rangeClosed(1, 100) // [1, 100]의 범위를 나타낸다.
                .filter(n -> n % 2 == 0);
        IntStream evenNumbers2 = IntStream.range(1, 100) // [1, 100]의 범위를 나타낸다.
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers1.count()); // 1부터 100까지에는 50개의 짝수가 있다.
        System.out.println(evenNumbers2.count()); // 1부터 100까지에는 49개의 짝수가 있다.
    }
}
