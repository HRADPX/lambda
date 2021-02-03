package com.kuaishou.api;

import com.kuaishou.model.DataInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 *  Lambda 表达式需要函数式接口支持
 *      函数式接口：只有一个方法的接口，可以用 FunctionInterface 注解检查
 */
public class LambdaLag {

    public static void main(String[] args) {

        List<DataInfo> list = new ArrayList<>();
        Lambda.init(list);

        // no arguments, no return
        Runnable r = () -> System.out.println("hello world!");
        r.run();

        System.out.println("=============================");

        // arguments, no return
        Consumer<Integer> con = (x) -> System.out.println(x);
        Consumer<Integer> cos = x -> System.out.println(x);
        con.accept(3);
        cos.accept(5);
        // 只有一个参数，小括号可以省略
        System.out.println("=============================");

        // arguments, return
        Comparator<Integer> comparator = (a,b) -> {
            System.out.println(a + " is compare " + b);
            return a - b;
        };
        System.out.println(comparator.compare(1, 2));

        // 如果一条语句，大括号和 return 都可以不写
        Comparator<Integer> com = (a,b) -> Integer.compare(a,b);
        Comparator<Integer> cop = (a,b) -> a - b;

        Collections.sort(list, (a,b) ->
                a.getId() == b.getId() ? a.getInfoId() - b.getInfoId() : a.getId() - b.getId());
        list.forEach(System.out::println);
    }
}
