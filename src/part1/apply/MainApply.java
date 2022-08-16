package part1.apply;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApply {
    public static void main(String[] args) {
        List<AppleVo> inventory = Arrays.asList(
                new AppleVo(80, "green"),
                new AppleVo(155, "green"),
                new AppleVo(120, "red")
        );
        /**** 기존필터  *****/
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        System.out.println(AppleFilter.filterGreenApples(inventory));
        // [Apple{color='green', weight=155}]
        System.out.println(AppleFilter.filterHeavyApples(inventory, 150));

        /***** JDK 8이상 필터표현방법 ****/
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<AppleVo> greenApples = AppleFilter.filterApples(inventory, AppleVo::isGreenApple);
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<AppleVo> heavyApples = AppleFilter.filterApples(inventory, AppleVo::isHeavyApple);
        System.out.println(heavyApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<AppleVo> greenApples2 = AppleFilter.filterApples(inventory, (AppleVo a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        /**** 익명함수 또는 람다 *****/
        // [Apple{color='green', weight=155}]
        List<AppleVo> heavyApples2 = AppleFilter.filterApples(inventory, (AppleVo a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // []
        List<AppleVo> weirdApples = AppleFilter.filterApples(inventory, (AppleVo a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);

        // 순차 처리 코드 방식
        List<AppleVo> seqHeavyApples = inventory.stream()
                .filter((appleVo -> appleVo.getWeight() > 150))
                .collect(Collectors.toList());
        System.out.println(seqHeavyApples);

        // 병렬 처리 코드 방식
        List<AppleVo> parallelHeavyApples = inventory.parallelStream()
                .filter((appleVo -> appleVo.getWeight() > 150))
                .collect(Collectors.toList());
        System.out.println(parallelHeavyApples);
    }
}
