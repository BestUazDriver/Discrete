package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();

        List<String> objects1 = new ArrayList<>();
        List<String> objects2 = new ArrayList<>();
        List<Integer> objects3 = new ArrayList<>();
        String str1 = "str1";
        String str2 = "str2";
        String str3 = "str3";
        String str4 = "str4";
        Integer int1 = 1;
        Integer int2 = 2;
        Integer int3 = 3;
        Integer int4 = 4;

        objects1.add(str1);
        objects1.add(str2);
        objects1.add(str3);

        objects2.add(str1);
        objects2.add(str2);
        objects2.add(str3);
        objects2.add(str4);


        objects3.add(int1);
        objects3.add(int2);
        objects3.add(int3);
        objects3.add(int4);

        lists.add(objects1);
        lists.add(objects2);
//        lists.add(objects3);

        System.out.println(lists);
    }
}
