package chapter02.quiz;

import chapter02.filter.AppleVo02;

import java.util.List;

public class PrettyPrintAppleFilter {
    public static void prettyPrintApple(List<AppleVo02> inventory, AppleFormatter formatter) {
        for(AppleVo02 apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
