package com.beofy.multithread.volatil;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

//    public static void main(String[] args) {
//        Integer i = 127;
//        Integer j = 127;
//        System.out.println(i==j);
//    }

//    public static void main(String[] args) {
//        Set<String> set = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return -o1.compareTo(o2);
//            }
//        });
//        set.add("A");
//        set.add("G");
//        set.add("E");
//        set.add("C");
//        for (String s: set) {
//            System.out.println(s);
//        }
//    }

    public static void main(String[] args) {
        String str1 = "a" + "c";
         String str2 = new String(str1);
            if (str2 == "ac")
                 System.out.println("= =");
            if (str1.equals(str2))
                 System.out.println("equals()");
    }
}
