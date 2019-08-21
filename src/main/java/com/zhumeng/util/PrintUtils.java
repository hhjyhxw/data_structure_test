package com.zhumeng.util;

public class PrintUtils {
    public static void print(Object[] aray){
        for (Object temp:aray){
            System.out.print(temp+";");
        }
    }

    public static void printLn(){
            System.out.println("=======================");
    }


}
