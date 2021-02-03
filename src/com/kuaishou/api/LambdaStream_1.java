package com.kuaishou.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * 创建流的方式
 *  (1) collection.stream()
 *  (2) Arrays.stream(array)
 *  (3) Stream.of();
 *  (4) Stream.iterate() 无限流
 *  (5) Stream.generate(Supplier<T> sup) 无限流
 */
public class LambdaStream_1 {

    public static void main(String[] args) {

        // 无限流
        Stream.iterate(1, x -> x + 2);

        Stream.generate(() -> (int)(Math.random() * 100)).limit(10).forEach(System.out::println);
    }
}
