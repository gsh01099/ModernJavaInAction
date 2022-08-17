package chapter02.filter;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(AppleVo02 appleVo02) {
        return Color.GREEN.equals(appleVo02.getColor());
    }
}
