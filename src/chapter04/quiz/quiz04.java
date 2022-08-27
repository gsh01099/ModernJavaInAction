package chapter04.quiz;

import chapter04.Dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class quiz04 {

    public static void chapter04첫번째문제(){
        // 제시된 외부 반복를 참고하여, 어떤 스트림 동작을 사용해 다음 코드를 리팩토링할 수 있을지 생각해보자.

        // 리펙토링 전 외부 반복
        List<String> highCaloricDishes1 = new ArrayList<>();
        Iterator<Dish> stringIterator = Dish.menu.iterator();
        while (stringIterator.hasNext()) {
            Dish dish = stringIterator.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes1.add(dish.getName());
            }
        }

        List<Dish> highCaloricDishes2 =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .collect(toList());
    }

    public static void chapter04두번째문제() {
        long count = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)       // 중간 연산
                .distinct()                                     // 중간 연산
                .limit(3)                               // 중간 연산
                .count();                                       // 최종 연산
    }
}
