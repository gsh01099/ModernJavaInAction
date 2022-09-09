package chapter05.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class PracticeMain {
    public static void main(String[] args) {
        /**
         * 예제 5-1 2011년에 일어난 모든 트랜잭션을 찾아서 값을 오름차순으로 정렬하시오.
         */
        List<Transaction> tr2011 =
                Transaction.transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)    // 2011년애 발생한 트랜잭션을 필터링하도록 프레디케이트를 넘겨줌
                        .sorted(Comparator.comparing(Transaction::getValue))    // 트랜잭션 값으로 요소 정렬
                        .collect(toList()); // 결과 스트림의 모든 요소를 리스트로 반환

        System.out.println("예제 5-1 2011년에 일어난 모든 트랜잭션을 찾아서 값을 오름차순으로 정렬하시오.");
        tr2011.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 예제 5-2 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
         */
        List<String> cities =
                Transaction.transactions.stream()
                        .map(transaction -> "toList 방식 :" + transaction.getTrader().getCity())// 트랜잭션과 관련한 각 거래자의 도시 추출
                        .distinct() // 고유 도시만 선택
                        .collect(toList());

        Set<String> citiesToSet =
                Transaction.transactions.stream()
                        .map(transaction -> "toSet 방식 :" + transaction.getTrader().getCity())// 트랜잭션과 관련한 각 거래자의 도시 추출
                        .collect(toSet());

        System.out.println("예제 5-2 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.");
        cities.forEach(System.out::println);
        citiesToSet.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 예제 5-3 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
         */
        List<Trader> traders =
                Transaction.transactions.stream()
                        .map(Transaction::getTrader)    // 트랜잭션의 모든 거래자 추출
                        .filter(trader -> "Cambridge".equals(trader.getCity()))     // 케임브리지의 거래자만 선택
                        .distinct()     // 중복이 없도록 확인
                        .sorted(Comparator.comparing(Trader::getName))      // 결과 스트림의 거래자를 이름으로 정렬
                        .collect(toList());
        System.out.println("예제 5-3 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.");
        traders.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 예제 5-4 모든 거래자의 이름을 알파뱃순으로 정렬해서 반환하시오.
         */
        String traderStr =
                Transaction.transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())  // 모든 거래자명을 문자열 스트림으로 추출
                        .distinct() // 각각의 이름을 하나의 문자열로 연결하여 결국 모든 이름 연결
                        .sorted()   // 중복된 이름 제거
                        .reduce("", (n1, n2) -> n1 + "." + n2);     // 이름을 알파벳순으로 정렬

        String traderStrJoining =
                Transaction.transactions.stream()
                        .map(transaction -> transaction.getTrader().getName() + "/")
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining());

        System.out.println("예제 5-4 모든 거래자의 이름을 알파뱃순으로 정렬해서 반환하시오.");
        System.out.println("reduce 활용 : " + traderStr);
        System.out.println("joining 활용 : " + traderStrJoining);
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 예제 5-5 밀라노에 거래자가 있는가?
         */
        boolean milanBased =
                Transaction.transactions.stream()
                        .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity())); // anyMatch에 프레디케이트를 전달해서 밀라노에 거래자가 있는지 확인

        System.out.println("예제 5-5 밀라노에 거래자가 있는가?");
        System.out.println(milanBased);
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 예제 5-6 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
         */
        Transaction.transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())) // 케임브리지에 거주 하는 거래자의 트랜잭션을 선택
                .map(Transaction::getValue)// 각 값을 출력
                .forEach(System.out::println); // 이 거래자들의 값을 추출
        System.out.println("예제 5-6 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.");
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 5-7 전체 트랜잭션중 최댓값은 얼마인가?
         */
        Optional<Integer> highestValue =
                Transaction.transactions.stream()
                        .map(Transaction::getValue) // 각 트랜잭션의 값 추출
                        .reduce(Integer::max);  // 결과 스트림의 최댓값 계산
        System.out.println("5-7 전체 트랜잭션중 최댓값은 얼마인가?");
        System.out.println(highestValue);
        System.out.println("------------------------------------------------------------------------------------");
        /**
         * 5-8 전체 트랙잭션 중 최솟 값은 얼마인가?
         */
        Optional<Transaction> smallestTransaction =
                Transaction.transactions.stream()
                        .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);   // 각 트랜잭션값을 반복 비교해서 가장 작은 트랜잭션 검색
        Optional<Transaction> smallestTransactionMin =
                Transaction.transactions.stream()
                                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("5-8 전체 트랙잭션 중 최솟 값은 얼마인가?");
        System.out.println("reduce를 활용한 최솟값 : "+smallestTransaction);
        System.out.println("min를 활용한 최솟값 : "+smallestTransactionMin);
        System.out.println("------------------------------------------------------------------------------------");
    }
}
