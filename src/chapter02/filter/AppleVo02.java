package chapter02.filter;

public class AppleVo02 {

    private int weight = 0;
    private Color color;

    public AppleVo02(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public AppleVo02() {

    }

    public AppleVo02(Integer weight) {
        this.weight = weight;
    }

    public AppleVo02(Color color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
}
