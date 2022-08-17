package chapter02.quiz;

import chapter02.filter.AppleVo02;

public class AppleSimpleFormatter implements AppleFormatter{
    @Override
    public String accept(AppleVo02 apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
