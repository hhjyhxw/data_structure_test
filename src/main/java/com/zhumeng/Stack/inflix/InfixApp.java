package com.zhumeng.Stack.inflix;

import com.zhumeng.util.StringUtil;

import java.io.IOException;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 */
public class InfixApp {
    public static void main(String[] args) throws IOException {
        String input,output;
        while (true){
            System.out.println("Enter infix: ");
            System.out.flush();
            input = StringUtil.getString();
            if(input.equals("**"))
                break;
            IntoPost theTrans = new IntoPost(input);
            output = theTrans.doTrans();
            System.out.println("Postfix is "+output+" ");


        }
    }
}
