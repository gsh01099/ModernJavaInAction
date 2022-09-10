package chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMake {
    //값으로 스트림 만들기
    public static void 값으로스트림만들기() {
        Stream<String> stream = Stream.of("Modern", "Java", " In", "Action");

        stream
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // null이 될 수 있는 객체로 스트림 만들기
    public static void null이될수있는객체로스트림만들기() {
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);
        System.out.println("삼항식 : " + homeValueStream);

        //ofNullable 사용
        Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home"));
        System.out.println("ofNullable : " + homeValueStream2);

        // flatMap과 함꼐 사용하는 상황
        Stream<String> values =
                Stream.of("config", "home", "user")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        System.out.println("flatMap : " + values);
    }

    // 배열로 스트림 만들기
    public static int 배열로스트림만들기() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        return Arrays.stream(numbers).sum(); // 합계는 41;
    }

    // 파일 스트림
    public static void 파일스트림() throws IOException {
        long uniqueWords = Files.lines(Paths.get("/Users/jjy/IdeaProjects/modernJavaInAction/src/chapter05/data.txt"), Charset.defaultCharset()) // 스트림은 자원을 자동으로 해제할 수 있는 AutoCloseable이므로 try-finally가 필요없다.
                .flatMap(line -> Arrays.stream(line.split(" "))) // 고유 단어 수 계산
                .distinct() // 중복제거
                .count();       // 단어 스트림 생성

        System.out.println("There are " + uniqueWords + " unique words in data.txt");
    }

    // inerate 메서드
    public static void inerate메서드(){
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    // 피보나치
    public static void 피보나치 () {
        // iterate를 이용한 피보나치
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
                .limit(10)
                .forEach(t -> System.out.printf("(%d, %d)", t[0], t[1]));

        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    // java9는 iterate 메소드는 프레디케이트 지원한다
    public static void java9_iterate() {
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        // takeWhile
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
    }

    // generate 메서드
    public static void generate메서드() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    // 변형된 피보나치수
    public static void 변형된피보나치수() {
        // Stream.generate을 이용한 요소 1을 갖는 스트림
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return previous;
            }

        };
        IntStream.generate(fib)
                .limit(10)
                .forEach(System.out::println);
    }
}
