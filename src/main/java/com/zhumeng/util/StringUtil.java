package com.zhumeng.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 */
public class StringUtil {
    public static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(reader);
        String s = rd.readLine();
        return s;
    }
}
