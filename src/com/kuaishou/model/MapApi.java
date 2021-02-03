package com.kuaishou.model;

import java.util.HashMap;
import java.util.Map;

/**
 * putIfAbsent(): 如果存在则不添加，返回已经存在的 value；如果不存在则添加。
 * compute():如果不存在并且新的 value 不为空，则新增。如果存在，并且新的不为空，则替换，为空则 remove()。
 *
 */
public class MapApi {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"2");
        String s = map.computeIfPresent(1,(x,y) -> x + y
        );
        System.out.println(s);

        System.out.println(map);
    }
}
