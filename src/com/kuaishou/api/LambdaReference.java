package com.kuaishou.api;

import com.kuaishou.model.DataInfo;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 对象::实例方法名
 *     Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表与返回值类型保持一致。
 *     如果 Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 ClassName :: method
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 */
public class LambdaReference {

    public static void main(String[] args) {

        // 对象::实例方法名
        Consumer<String> con = System.out::println;
        con.accept("aggds");

        // 类::静态方法名
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        System.out.println(com.compare(1, 2));


        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1,2));

        DataInfo dataInfo = new DataInfo(1,2);
        Supplier<Integer> sup = dataInfo :: getInfoId;
        Supplier<Integer> supplier = () -> dataInfo.getInfoId();
        System.out.println(sup.get());
        System.out.println(supplier.get());

        // 如果 Lambda 参数列表中的第一个参数是实例方法的调用者，
        // 而第二个参数是实例方法的参数时，可以使用 ClassName :: method
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        BiPredicate<String, String> predicate = String :: equals;
        System.out.println(biPredicate.test("a", "a"));
        System.out.println(predicate.test("1","3"));


        // 构造器引用
        Supplier<DataInfo> su = DataInfo::new;
        System.out.println(su.get());

        Function<Integer, DataInfo> function = DataInfo::new;
        System.out.println(function.apply(1));

    }
}
