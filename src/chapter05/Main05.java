package chapter05;

import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;

public class Main05 {

    public static void main(String[] args) throws IOException {
        Filtering.프레디케이트필터링();
        Filtering.고유요소필터링();

        Slicing.기존방법의필터링();
        Slicing.takeWhile을이용한슬라이스();
        Slicing.dropWhile을이용한슬라이스();
        Slicing.선택한수만큼값돌려주는메소드();
        Slicing.요소건너띄기();

        Mapping.map메서드로전달후추출();
        Mapping.글자수를리스트로반환();
        Mapping.요리명의길이추출();
        Mapping.고유문자로이루어진리스트반환();
        Mapping.문자열을스트림으로변환예제();
        Mapping.flatMap사용();

        Find.요소검색();
        Find.첫번째요소찾기();

        NumberStream.숫자범위확인메서드();
        Pythagoras.피타고라스수();

        StreamMake.값으로스트림만들기();
        StreamMake.null이될수있는객체로스트림만들기();
        StreamMake.파일스트림();
        StreamMake.피보나치();

        StreamMake.generate메서드();
        StreamMake.변형된피보나치수();
    }
}
