package chapter03.quiz;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class methodReference {
    public void main(String[] args) {
        ToIntFunction<String> stringToint = (String s) -> Integer.parseInt(s);
        ToIntFunction<String> stringToInteger = Integer::parseInt;

        BiPredicate<List<String>, String> contains = ((stringList, s) -> stringList.contains(s));
        BiPredicate<List<String>, String> contains2 = List::contains;

        Predicate<String> startsWithNumber = (String string) -> this.equals("");
        Predicate<String> startsWithNumber2 = this::equals;

    }
}
