package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Mapping {

    //Dish::getName을 map 메서드로 전달해 추출
    public static void map메서드로전달후추출() {
        List<String> dishNames =
                Dish.menu.stream()
                        .map(Dish::getName)
                        .collect(toList());

        dishNames.forEach(System.out::println);
    }

    // 글자 수의 리스트를 반환
    public static void 글자수를리스트로반환() {
        List<String> words = Arrays.asList(
                "Modern",
                "Java",
                "In",
                "Action"
        );

        List<Integer> wordLengths =
                words.stream()
                        .map(String::length)
                        .collect(toList());

        wordLengths.forEach(System.out::println);
    }

    // 요리명의 길이 추출 여러개의 중간 연산 붙이기
    public static void 요리명의길이추출() {
        List<Integer> dishNameLengths =
                Dish.menu.stream()
                        .map(Dish::getName)
                        .map(String::length)
                        .collect(toList());

        dishNameLengths.forEach(System.out::println);
    }

    // 고유문자로 이루어진 리스트 반환 ["Hello", "World"] -> ["H", "e", "l" , "o", "W", "r", "d"]
    public static void 고유문자로이루어진리스트반환() {
        List<String> words = Arrays.asList(
                "Hello",
                "World"
        );

        List<String[]> wordArray =
                words.stream()
                        .map(word -> word.split(""))
                        .distinct()
                        .collect(toList());

        wordArray.forEach(strings -> System.out.println(strings.toString()));
    }

    // map과 Arrays.stream 활용
    public static void 문자열을스트림으로변환예제() {
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);


        List<String> words = Arrays.asList(
                "Hello",
                "World"
        );

        List<Stream<String>> w =  words.stream()
                .map(word -> word.split(""))// 각 단어를 개별 문자열 배열로 변환
                .map(Arrays::stream)// 각 배열을 별도의 스트림으로 생성
                .distinct()
                .collect(toList());

        w.forEach(System.out::println);
    }

    // flatMap 사용
    public static void flatMap사용() {
        List<String> words = Arrays.asList(
                "Hello",
                "World"
        );

        List<String> uniqueCharacters =
                words.stream()
                        .map(word -> word.split(""))// 각 단어를 개별 문자를 포함하는 배열로 변환
                        .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                        .distinct()
                        .collect(toList());

        uniqueCharacters.forEach(System.out::println);

    }
}

