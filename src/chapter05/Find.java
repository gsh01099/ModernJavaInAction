package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Find {

    // 요소검색
    public static void 요소검색() {
        Optional<Dish> dish =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny(); // Optional<Dish>를 반환

        System.out.println(dish);

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny() // Optional<Dish>를 반환
                .ifPresent(dish1 ->  System.out.println(dish1.getName())); // 값이 있으면 출력되고, 값이 없으면 아무일도 일어나지 않는다.
    }

    // 첫번째 요소 찾기
    public static void 첫번째요소찾기() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        .findFirst();

        System.out.println(firstSquareDivisibleByThree);
    }
}
