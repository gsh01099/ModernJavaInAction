package chapter05;

import chapter04.Dish;

public class Match {

    // 프레디케이트가 적어도 한 요소와 일치하는지 확인
    public static void 프레디케이트가적어도한요소와일치하는지확인() {
        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu if (somewhat) vegetarian friendly!!!");
        }
    }

    // 프레디케이트가 모든 요소와 일치하는지 검사
    public static void 프레디케이트가모든요소와일치하는지검사() {
        boolean isHealthy = Dish.menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
    }

    // 프레디케이트와 일치하지 않는 요소 검사
    public static void  프레디케이트와일치하지않는요소검사() {
        boolean isHealthy = Dish.menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
    }

}
