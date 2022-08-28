package chapter05;

import chapter04.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Slicing {

    // 기준 -> 320칼로리 이하의 요리 선택 기존에 사용 하던 filter 방식
    public static void 기존방법의필터링() {
        List<Dish> filteredMenu =
                Dish.specialMenu.stream()
                        .filter(dish -> dish.getCalories() < 320)
                        .collect(toList());

        filteredMenu.forEach(System.out::println);
    }

    // 320 칼로리보다 크거나 같은 요리가 나왔을때 반복을 중단한다
    public static void takeWhile을이용한슬라이스() {
        List<Dish> slicedMenu1 =
                Dish.specialMenu.stream()
                        .takeWhile(dish -> dish.getCalories() < 320)
                        .collect(toList());

        slicedMenu1.forEach(System.out::println);
    }

    // 반대로 320 칼로리 보다 큰 요리를 선택한다.
    public static void dropWhile을이용한슬라이스() {
        List<Dish> slicedMenu2 =
                Dish.specialMenu.stream()
                        .dropWhile(dish -> dish.getCalories() < 320)
                        .collect(toList());

        slicedMenu2.forEach(System.out::println);
    }

    // 주어진 값 이하의 크기를 갖는 새로운 스트림을 반환하는 메소드
    public static void 선택한수만큼값돌려주는메소드() {
        List<Dish> dishes =
                Dish.specialMenu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .limit(3)
                        .collect(toList());

        dishes.forEach(System.out::println);
    }

    // 요소 건너띄기
    public static void 요소건너띄기() {
        List<Dish> dishes =
                Dish.specialMenu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .skip(2)
                        .collect(toList());

        System.out.println(dishes.toArray());
    }
}
