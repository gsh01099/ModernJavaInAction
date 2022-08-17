package chapter02.quiz;

import chapter02.filter.AppleVo02;
import chapter02.filter.Color;

import java.util.Arrays;
import java.util.List;

public class QuizMain01 {
    public static void main(String[] args) {
        List<AppleVo02> inventory = Arrays.asList(
                new AppleVo02(80, Color.GREEN),
                new AppleVo02(155, Color.GREEN),
                new AppleVo02(120, Color.RED)
        );

        PrettyPrintAppleFilter.prettyPrintApple(inventory, new AppleFancyFormatter());
        PrettyPrintAppleFilter.prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}
