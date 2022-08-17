package chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {

    // JDK 8버전 이후 Predicate를 이용해 필터 방법
    public static List<AppleVo> filterApples(List<AppleVo> inventory, Predicate<AppleVo> p ) {
        List<AppleVo> result = new ArrayList<>();
        for (AppleVo apple : inventory ) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // JDK 8버전 이전 필터 방법
    // green 색의 사과만 필터 하는 메소드
    public static List<AppleVo> filterGreenApples(List<AppleVo> inventory) {
        List<AppleVo> result = new ArrayList<>();

        for (AppleVo apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
   }

    // 특정무개 이상 사과 필터하는 메소드
    public static List<AppleVo> filterHeavyApples(List<AppleVo> inventory, int weight){
        List<AppleVo> result = new ArrayList<>();
        for (AppleVo apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

}
