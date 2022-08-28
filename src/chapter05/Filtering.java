package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Filtering {

    public static void 프레디케이트필터링(){
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(dish -> dish.isVegetarian())
                .collect(toList());

        vegetarianMenu.forEach(System.out::println);
    }

    public static void 고유요소필터링(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 ==0)
                .distinct()
                .forEach(System.out::println);

        // 스트림은 한번만 사용된다는거 눈으로 확인
        System.out.println(numbers);
    }
}
