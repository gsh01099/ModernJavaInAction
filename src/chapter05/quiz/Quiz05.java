package chapter05.quiz;

import chapter04.Dish;
import chapter04.Type;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Quiz05 {
    // 스트림을 이용해서 처음 등장하는 두 고기 요리를 필터링 하시오
    public static void 두고기요라필터링() {
        List<Dish> dishes =
                Dish.menu.stream()
                        .filter(dish -> dish.getType() == Type.MEAT)
                        .limit(2)
                        .collect(toList());

        dishes.forEach(System.out::println);
    }

    /**
       * 1. 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오.
       * 예를 들어 [1,2,3,4,5]가 주어지면 [1,4,9,16,25]를 반환해야 한다.
     **/

    public static void 숫자곱하기(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> numberStrem =
                numbers.stream()
                        .map(i -> i * i)
                        .collect(toList());

        numberStrem.forEach(System.out::println);
    }

    /**
     * 2. 두 개의 숫자 리스트가 있을 때 모든 숫자 상의 리스트를 반환히사오.
     * 예를 들어 두 개의 리스트 [1,2,3]과 [3,4]가 주어 지면
     * [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]를 반환해야 한다.
     * **/

    public static void flatMap을이용한문제해결() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> listIntArray =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        listIntArray.forEach(System.out::println);
    }

    /**
     * 3. 이전 예제에서 합이 3으로 나누어떨어지는 쌍만 반환하려면 어떻게 해야 할까?
     * 예를 들어 (2,4), (3,3)을 반환해야한다.
     * **/
    public static void flatMap에flatMap() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> listIntArray =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .filter(j  -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        System.out.println(listIntArray.toArray());
    }

    // 리듀스
    // map과 reduce 메소드를 이용해서 스트림의 요리 개수를 계산하시오.
    public static void 리듀스퀴즈() {
        int count =
                Dish.menu.stream()
                        .map(dish -> 1)
                        .reduce(0, (a,b) -> a + b);

        long count2 = Dish.menu.stream().count();
    }
}
