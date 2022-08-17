package chapter02.filter;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter02 {

    // 기존에 필터 하는방법
    public static List<AppleVo02> filterGreenApples(List<AppleVo02> inventory) {
        List<AppleVo02> result = new ArrayList<>(); // 사과 누적 리스트
        for (AppleVo02 apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) { // 녹색 사과만 선택
                result.add(apple);
            }
        }
        return result;
    }

    // 파라미터를 통하여 필터링하는 방법
    public static List<AppleVo02> filterApplesByColor(List<AppleVo02> inventory, Color color) {
        List<AppleVo02> result = new ArrayList<>();
        for (AppleVo02 apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 위의 소스를 복붙하여, 색 파라미터를 무게 파라미터로만 변경
    public static List<AppleVo02> filterApplesByWeight(List<AppleVo02> inventory, int weight) {
        List<AppleVo02> result = new ArrayList<>();
        for (AppleVo02 apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    // 가능한 모든 속성으로 필터링 (실전에서는 절대 이 방법을 사용하지 말아야 한다.)
    public static List<AppleVo02> filterApples(List<AppleVo02> inventory, Color color, int weight, boolean flag) {
        List<AppleVo02> result = new ArrayList<>();
        for (AppleVo02 apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                (!flag && apple.getWeight() > weight)) { // 색이나 무게를 선택 하는 방법이 마음에 들지 않는다.
                result.add(apple);
            }
        }
        return result;
    }

    // 인터페이스를 사용! 전략 디자인 패턴 활용!
    public static List<AppleVo02> filterApples(List<AppleVo02> inventory, ApplePredicate predicate) {
        List<AppleVo02> result = new ArrayList<>();
        for (AppleVo02 apple : inventory) {
            if (predicate.test(apple)) { // 프레디케이트 객체로 사과 검사 조건을 캡슐화 했다.
                result.add(apple);
            }
        }
        return result;
    }

    // 제네릭을 사용!!!
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
 }
