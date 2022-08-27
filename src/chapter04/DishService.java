package chapter04;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class DishService {

    public static void 자바7과자바8문법비교_스트림(){
        // 자바7
        List<Dish> lowCaloricdishes_java7_ex1 = new ArrayList<>();

        for(Dish dish : Dish.menu) {
            if (dish.getCalories() < 400) {
                lowCaloricdishes_java7_ex1.add(dish);
            }
        }

        // Collection 이용
        List<Dish> lowCaloricdishes_java7_ex2 = new ArrayList<>();

        Collections.sort(lowCaloricdishes_java7_ex2, new Comparator<Dish>() { // 익명 클래스로 요리정렬
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricdishes_java7_ex2) {
            lowCaloricDishesName.add(dish.getName());
        }

        // 자바 8
        List<String> lowCaloricDishesName_java8 =
                Dish.menu.stream()
                        .filter(d -> d.getCalories() < 400)         // 400칼로리 이하의 요리 선택
                        .sorted(comparing(Dish::getCalories))       // 칼로리로 요리정렬
                        .map(Dish::getName)         // 요리명 추출
                        .collect(toList());         // 모든 요리명을 리스트에 저장

        // 멀티코어 아키텍처에서 병렬 실행
        List<String> lowCaloricDishesName_java8_2 =
                Dish.menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)         // 400칼로리 이하의 요리 선택
                        .sorted(comparing(Dish::getCalories))       // 칼로리로 요리정렬
                        .map(Dish::getName)         // 요리명 추출
                        .collect(toList());         // 모든 요리명을 리스트에 저장
    }

    public static void 스트림설명기반예제() {
        List<String> threeHighCaloricDishNames =
            Dish.menu.stream()                  // 메뉴(요리 리스트)에서 스트림을 얻는다.
                    .filter(dish -> dish.getCalories() > 300)       // 파이프라인 연산 만들기,                -- 중간연산
                    .map(Dish::getName)    // 요리명추출               // 첫번째로 고칼로리 요리를 필터링한다.      -- 중간연산
                    .limit(3) // 선착순 세 개만 추출                                                -- 중간연산
                    .collect(toList()); // 결과를 다른 리스트로 저장                                           -- 최종연산
        System.out.print(threeHighCaloricDishNames);    // 결과는 [pork, beef, chicken] 출력
    }

    public  static void 학습용스트림() {
        List<String> names =
                Dish.menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering -> " + dish.getName());
                            return dish.getCalories() > 300;
                        })          // 필터링한 요리명을 출력한다.
                        .map(dish -> {
                            System.out.println("mapping -> " + dish.getName());
                            return dish.getName();
                        })          // 추출한 요리명을 추출한다.
                        .limit(3)
                        .collect(toList());
    }

    public static  void 외부반복과내부반복() {
        // 내부반복
        // Iterator 객체 이용
        // 켈력션 : 내부적으로 숨겨졌던 반복자를 사용한 외부 반복
        List<String> names1 = new ArrayList<>();
        Iterator<Dish> stringIterator = Dish.menu.iterator();
        while (stringIterator.hasNext()) {  // 명시적 반복
            Dish dish = stringIterator.next();
            names1.add(dish.getName());
        }

        // 외부반복
        List<String> names2 = Dish.menu.stream()
                .map(Dish::getName) // map 메소드를 getName 메서드로 파라미터화해서 요리명을 추출한다.
                .collect(toList()); // 파이프라인을 실행한다. 반복자는 필요 없다.
    }
}
