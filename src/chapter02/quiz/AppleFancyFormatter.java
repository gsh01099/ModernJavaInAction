package chapter02.quiz;

import chapter02.filter.AppleVo02;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public String accept(AppleVo02 apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";

        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
