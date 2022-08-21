package chapter03.example;

import chapter02.filter.AppleVo02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionEx {
    public static <T, R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    // 생성자 참조 형식
    public static List<AppleVo02> map2(List<Integer> list, Function<Integer, AppleVo02> f) {
        List<AppleVo02> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
