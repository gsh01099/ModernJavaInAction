package chapter02;

import chapter02.filter.*;
import chapter02.filter.Color;

import java.awt.*;
import java.beans.EventHandler;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class Main02 {
    public static void main(String[] args) {
        List<AppleVo02> inventory = Arrays.asList(
                new AppleVo02(80, Color.GREEN),
                new AppleVo02(155, Color.GREEN),
                new AppleVo02(120, Color.RED)
        );

        // 기존에 필터 하는방법
        System.out.println(AppleFilter02.filterGreenApples(inventory));
        // 파라미터를 통하여 필터링하는 방법
        System.out.println(AppleFilter02.filterApplesByColor(inventory,Color.RED));
        System.out.println(AppleFilter02.filterApplesByWeight(inventory, 150));
        // 가능한 모든 속성으로 필터링 (실전에서는 절대 이 방법을 사용하지 말아야 한다.)
        System.out.println(AppleFilter02.filterApples(inventory, Color.GREEN,0, true));
        System.out.println(AppleFilter02.filterApples(inventory, null,150, false));
        // 인터페이스를 사용! 전략 디자인 패턴 활용!
        System.out.println(AppleFilter02.filterApples(inventory, new AppleGreenColorPredicate()));
        System.out.println(AppleFilter02.filterApples(inventory, new AppleRedColorPredicate()));
        // 익명 클래스를 사용하여 필터링
        System.out.println(AppleFilter02.filterApples(inventory, new ApplePredicate() { // filterApples 메소드의 동작을 직접 파라미터화 했다.
            @Override
            public boolean test(AppleVo02 appleVo02) {
                return Color.RED.equals(appleVo02.getColor());
            }
        }));

        // jdk8 이상의 람다표현식
        List<AppleVo02> result = AppleFilter02.filterApples(inventory, (AppleVo02 apple) -> Color.RED.equals(apple.getColor()));

        // 제네릭을 통해서 바나나,오렌지,정수 문자열 등 리스트에 필터 메섣드를 사용 가능
        List<Integer> numbers = Arrays.asList(
                1, 2, 4, 5, 6, 7, 8
        );

        List<Integer> evenNumbers = AppleFilter02.filter(numbers, (Integer i)  -> i % 2 ==0);
        System.out.println(evenNumbers);


        // 람다 쓰레드
        Thread t = new Thread(() -> System.out.println("난 람다식 쓰레드야 방가워"));
        System.out.println(t.getId());

        // GUI 쓰레드 이름 반환 태스크
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        System.out.println(threadName);

        // 람다식 표현 GUI
        Future<String> threadNameLambda = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println(threadNameLambda);

    }
}
