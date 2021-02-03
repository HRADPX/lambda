package com.kuaishou.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java 8 中 4 个核心接口
 *
 *   (1) Consumer<T> 消费型接口
 *      void accept(T t);
 *
 *   (2) Supplier<T> 供给型接口
 *      T get();
 *
 *   (3) Function<T,R> 函数型接口
 *
 *   (4) Predicat<T> 断言型接口
 *      boolean test(T t)
 */
public class LambdaInnerInterface {

    public static void main(String[] args) {

        // 消费型接口
        consume(220,m -> System.out.println("consume money: " + m));
        // 供给型接口
        supplier(4,() -> (int)(Math.random() * 100)).forEach(System.out::println);
        // 函数型接口
        System.out.println(function("getId", (s) -> s.toUpperCase()));
        // 断言型接口
        List<String> list = Arrays.asList("aaa","12345","abdsc","a","b");
        predicate(list,m -> m.length() > 3).forEach(System.out::println);

    }

    public static void consume(int money, Consumer<Integer> con){
        con.accept(money);
    }

    public static List<Integer> supplier(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    public static String function(String string, Function<String,String> fun) {
        return fun.apply(string);
    }

    public static List<String> predicate(List<String> stringList, Predicate<String> pre) {
        List<String> list = new ArrayList<>();
        for (String s : stringList) {
            if(pre.test(s))
                list.add(s);
        }
        return list;
    }
}
