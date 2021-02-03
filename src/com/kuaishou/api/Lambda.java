package com.kuaishou.api;

import com.kuaishou.model.DataInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambda {

    public static void main(String[] args) {

        List<DataInfo> list = new ArrayList<>();
        init(list);
        // 条件过滤
        list.stream().filter((e) -> e.getId() >= 5).forEach(System.out::println);
        System.out.println("========================");

        // 条件过滤
        list.stream().filter((e) -> e.getId() >= 5).limit(2).forEach(System.out::println);
        System.out.println("========================");

        // Steam API
        list.stream().filter((e) -> e.getId() >= 5).map(DataInfo::getId).
                forEach(System.out::println);

    }

    public static void init(List<DataInfo> list) {

        list.add(new DataInfo(1,1));
        list.add(new DataInfo(2,2));
        list.add(new DataInfo(3,3));
        list.add(new DataInfo(4,3));
        list.add(new DataInfo(5,4));
        list.add(new DataInfo(6,5));
        list.add(new DataInfo(7,6));
    }
}
