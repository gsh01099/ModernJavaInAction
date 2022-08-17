package chapter02.filter;

public class AppleRedColorPredicate implements ApplePredicate{
    @Override
    public boolean test(AppleVo02 appleVo02) {
        return Color.RED.equals(appleVo02.getColor());
    }
}
