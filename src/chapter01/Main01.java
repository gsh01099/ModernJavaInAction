package chapter01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main01 {
    public static void main(String[] args) {
        List<AppleVo01> inventory = Arrays.asList(
                new AppleVo01(80, "green"),
                new AppleVo01(155, "green"),
                new AppleVo01(120, "red")
        );
        /**** 기존필터  *****/
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(AppleFilter01.filterGreenApples(inventory));
        // [Apple{color='green', weight=155}]
        System.out.println(AppleFilter01.filterHeavyApples(inventory, 150));

        /***** JDK 8이상 필터표현방법 ****/
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<AppleVo01> greenApples = AppleFilter01.filterApples(inventory, AppleVo01::isGreenApple);
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<AppleVo01> heavyApples = AppleFilter01.filterApples(inventory, AppleVo01::isHeavyApple);
        System.out.println(heavyApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<AppleVo01> greenApples2 = AppleFilter01.filterApples(inventory, (AppleVo01 a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        /**** 익명함수 또는 람다 *****/
        // [Apple{color='green', weight=155}]
        List<AppleVo01> heavyApples2 = AppleFilter01.filterApples(inventory, (AppleVo01 a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // []
        List<AppleVo01> weirdApples = AppleFilter01.filterApples(inventory, (AppleVo01 a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);

        // 순차 처리 코드 방식
        List<AppleVo01> seqHeavyApples = inventory.stream()
                .filter((appleVo -> appleVo.getWeight() > 150))
                .collect(Collectors.toList());
        System.out.println(seqHeavyApples);

        // 병렬 처리 코드 방식
        List<AppleVo01> parallelHeavyApples = inventory.parallelStream()
                .filter((appleVo -> appleVo.getWeight() > 150))
                .collect(Collectors.toList());
        System.out.println(parallelHeavyApples);
    }
}
