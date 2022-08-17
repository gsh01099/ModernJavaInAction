package chapter02.filter;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(AppleVo02 appleVo02) {
        return appleVo02.getWeight() > 150;
    }
}
