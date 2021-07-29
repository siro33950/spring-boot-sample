package com.example.demo.domain;


import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Builder
public class Abc166 {

    UUID id;

    String input;

    String output;

    public static Abc166 createA(String input) {
        String output;
        if (input.equals("ABC")) {
            output = "ARC";
        } else {
            output = "ABC";
        }
        return Abc166.builder().id(UUID.randomUUID()).input(input).output(output).build();
    }

    public static Abc166 createB(String input) {

        List<Integer> intList = Arrays.stream(input.replaceAll("\n", " ").split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // スペース区切りの整数の入力
        int N = intList.remove(0);
        int K = intList.remove(0);

        List<Integer> nList = IntStream.range(1, N + 1).boxed().collect(Collectors.toList());

        for (int i = 0; i < K; i++) {
            // 整数の入力
            int di = intList.remove(0);
            for (int j = 0; j < di; j++) {
                int A = intList.remove(0);
                int index = nList.indexOf(A);
                if (index != -1) {
                    nList.remove(index);
                }
            }
        }

        return Abc166.builder().id(UUID.randomUUID()).input(input).output(Integer.toString(nList.size())).build();
    }
}
