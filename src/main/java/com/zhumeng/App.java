package com.zhumeng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {

        System.out.println( "Hello World!" );
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date oldDate = format.parse("2011-05-12 15:16:00"); //这里时间可以自己定
        if(date.after(oldDate)) //判断,如果时间在这时间后,就执行后面操作
            System.out.print("投票时间已经过了!谢谢你的参与！");
        else
            System.out.print("可以继续投票,时间还没有过！");

        Map<String,String> map = new HashMap<String, String>(3);
        Map<String,String> maps = new HashMap<String, String>();

        Hashtable<String,String> tabls = new Hashtable<String, String>();
        map.put("s","d");

         final int MAXIMUM_CAPACITY = 1 << 30;

        int n = 5 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

//        n = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.print("n======"+n);
        System.out.print("8>2======"+(Integer.MAX_VALUE << 2));
    }

}
