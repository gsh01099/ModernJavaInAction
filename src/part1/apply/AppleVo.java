package part1.apply;

public class AppleVo {

    private int weight = 0;
    private String color = "";

    public AppleVo() {}

    public AppleVo(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // JDK 8버전 이후 Predicate를 이용해 필터 방법
    public static boolean isGreenApple(AppleVo appleVo) {
        return "green".equals(appleVo.getColor());
    }
    public static boolean isHeavyApple(AppleVo appleVo) {
        return appleVo.getWeight() > 150;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color='%s', weight=%d}", color, weight);
    }
}
