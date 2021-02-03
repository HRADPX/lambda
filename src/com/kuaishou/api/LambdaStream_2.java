package com.kuaishou.api;

import com.kuaishou.model.DataInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/*
 * 中间操作
 * 1. 筛选与切片
 */
public class LambdaStream_2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        init(list);
        list.stream().filter(x -> x > 40) // 过滤
                .limit(10) // 截断，短路操作，找到匹配的后面就不执行了
                .skip(5)   // 跳过
                .distinct()  // 去重，根据 hashCode() 和 equals() 方法
                .forEach(System.out::println);

        System.out.println("=========================================");

        Map<Integer,Integer> map = new HashMap<>();
        List<DataInfo> dataInfos = new ArrayList<>();
        initObject(dataInfos);
        dataInfos.stream().map(dataInfo -> dataInfo.getInfoId()).forEach(System.out::println);
        dataInfos.stream().map(DataInfo::getInfoId).forEach(System.out::println);
        dataInfos.forEach(dataInfo -> map.put(dataInfo.getId(),dataInfo.getInfoId()));
        Map<Integer, Integer> collect = dataInfos.stream().collect(Collectors.toMap(DataInfo::getId, DataInfo::getInfoId));
        Map<Integer, Integer> collect1 = dataInfos.stream().collect(Collectors.toMap((x) -> x.getId(),(y) -> y.getInfoId()));
//        System.out.println(map);
//        System.out.println(collect);
        System.out.println(list.stream().reduce(BinaryOperator.maxBy(Integer::compareTo)));

        System.out.println(dataInfos.stream().map(DataInfo::getId).max(Integer::compareTo));
    }

    private static void init(List<Integer> list) {

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    private static void initObject(List<DataInfo> list) {

        for (int i = 0; i < 10; i++) {
            list.add(new DataInfo(i, i * i));
        }
    }
}
