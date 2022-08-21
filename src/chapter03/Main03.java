package chapter03;

import chapter02.filter.AppleVo02;
import chapter02.filter.Color;
import chapter03.example.*;
import chapter03.example.IntPredicate;
import chapter03.sort.AppleComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main03 {
    public static void main(String[] args) throws IOException {

        // Runnable 예제
        Runnable r1 = () -> System.out.println("Hello World 1"); // 람다 사용

        Runnable r2 = new Runnable() {  // 익명 클래스 사용
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        RunnableEx.process(r1);
        RunnableEx.process(r2);
        RunnableEx.process(() -> System.out.println("Hello World 3")); // 직접 전달된 람다 표현식

        // BufferedReader  예제
        String oneLine = ProcessFileEx.processFile((BufferedReader br) -> br.readLine());
        String twoLines = ProcessFileEx.processFile((BufferedReader br) -> br.readLine() + br.readLine());

        System.out.println(oneLine);
        System.out.println(twoLines);

        // Predicate 테스트 (boolean 일때 사용)
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.addAll(Arrays.asList("test", "", "test3"));

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = PredicateEx.filter(listOfStrings, nonEmptyStringPredicate);

        System.out.println(nonEmpty);

        // Consumer 예제
        ConsumerEx.forEach(
                Arrays.asList(1,2,3,4,5),
                (Integer i) -> System.out.println(i) // Consumer의 accept 메소드를 구현하는 람다
        );
        // Function 예제
        List<Integer> l = FunctionEx.map (
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length() // Function의 apply 메소드를 구현하는 람다
        );

        System.out.println(l);

        // 기본형 -> 참조형 박싱 참조형 -> 기본형 언박싱
        // 오토박싱 예제
        List<Integer> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            list.add(i);// List는 참조형 Integer 이지만 오토박싱으로 인행 기본형(int)가 참조형(Integer)로 변환되어 저장
        }

        IntPredicate evenNumbers = (int i) -> i % 2 ==0;
        evenNumbers.test(1000); // 참(박싱 없음)

        System.out.println(evenNumbers);

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 !=0;
        oddNumbers.test(1000); // 거짓 (박싱)

        System.out.println(oddNumbers);

        // 람다 캡처링, 자유변수
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        r.run();

        // 람다 캡처링 오류, 캡처링은 한번만 사용 되는 지역변수나, final로 선언된 변수 또는 그렇게 사용되는 변수만 사용할수있다.
        int portNumber2 = 1337;
        Runnable r_1 = () -> System.out.println(portNumber2);
        //
        // portNumber2 = 1339; // 이렇게 재할당을 할수 있게 되면 오류가 발생함


        // 메소드 참조 sort 예제
        List<String> str = Arrays.asList("a", "b", "c", "d", "e");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2)); // -> 람다 표현식
        str.sort(String::compareToIgnoreCase); // 메소드 참조 이용

        // 생성자 참조
        Supplier<AppleVo02> sa = () -> new AppleVo02();
        Supplier<AppleVo02> saNew = AppleVo02::new;

        Function<Integer, AppleVo02> fa = (weight) -> new AppleVo02(weight);
        Function<Integer, AppleVo02> faNew = AppleVo02::new;

        List<Integer> weights = Arrays.asList(7,3,4,10);
        List<AppleVo02> apples = FunctionEx.map(weights, AppleVo02::new);

        BiFunction<Color, Integer, AppleVo02> bfi = (color, weight) -> new AppleVo02(color, weight);
        AppleVo02 bfia = bfi.apply(Color.GREEN, 100);
        BiFunction<Color, Integer, AppleVo02> bfiNew = AppleVo02::new; // Apple(String color, Integer weight)의 생성자 참조
        AppleVo02 bfiaNew = bfiNew.apply(Color.GREEN, 100);

        // 정렬 들어갑니다

        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.RED)
        );

        // comparator을 구현 하여 사용
        inventory.sort(new AppleComparator());

        // 익명함수 사용 (한번만사용할거면 사용해도 될듯)
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        // 람다식으로 개선된 코드
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        // 람다의 파라미터 형식 추론을 통해 개선된 코드
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        // 정적 메소드를 이요하여 개선된 코드
        Comparator<Apple> ca = Comparator.comparing((Apple a) -> a.getWeight());
        inventory.sort(Comparator.comparing(apple -> apple.getWeight()));

        // 메소드 참조를 통해 개선된 코드
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("정렬 : " + inventory);
        // 역정렬
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println("역정렬 : " + inventory);
        // 두번째 비교자 설정
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println("비교자 두우개 : " + inventory);

        // Function 예제
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        int resultFunction = h.apply(1);
        int resultFunction2 = h2.apply(1);

        System.out.println(resultFunction);
        System.out.println(resultFunction2);

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                        .andThen(Letter::addFooter);
        System.out.println(transformationPipeline.toString());
    }
}
