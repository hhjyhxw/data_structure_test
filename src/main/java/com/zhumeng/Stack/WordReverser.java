package com.zhumeng.Stack;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 */

/**
 * 内部类
 */
class WordReverser {
    private String input;
    private String output;

    public WordReverser(String in){
        this.input = in;
    }

    public String doRe(){
        int stackSize = input.length();
        WordStack stack = new WordStack(stackSize);
        for (int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            stack.push(ch);
        }
        output = "";
        while (!stack.isEmpty()){
            output = output + stack.pop();
        }
        return output;
    }

}
