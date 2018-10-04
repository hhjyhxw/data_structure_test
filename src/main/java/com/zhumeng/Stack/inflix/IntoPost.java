package com.zhumeng.Stack.inflix;

import com.zhumeng.Stack.Stack;

/**
 * Created by 512162086@qq.com on 2018/10/4 .
 * 利用栈 结构 把 中缀表达式 转为 后缀表达式
 */
public class IntoPost {
    private InfixStack infixStack;
    private String input;
    private String output="";

    public IntoPost(String in){
        this.input = in;
        int stackSize = this.input.length();
        infixStack = new InfixStack(stackSize);
    }


    public String doTrans(){
        for (int i = 0; i <this.input.length() ; i++) {
            char ch = this.input.charAt(i);
            infixStack.displayInfixStack("For "+ch+" ");
            switch(ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    infixStack.push(ch);//
                    break;
                case ')':
                    gotParen(ch);
                    break;
            }//end switch
        }//end for
        while (!infixStack.isEmpty()){
            infixStack.displayInfixStack("While ");
            output = output + infixStack.pop();
            infixStack.displayInfixStack("End ");
        }
        return output;
    }

    public void  gotOper(char opThis,int prec1){
        while (!infixStack.isEmpty()){
            char opTop = infixStack.pop();
            if (opTop=='('){//左边操作符 入栈
                infixStack.push(opTop);
                break;
            }else{
                //it is an operator
                int prec2;
                if(opTop=='+' || opTop=='-')
                    prec2=1;
                else
                    prec2 =2;
                if(prec2<prec1){//if prec of new op less than prec of old
                    infixStack.push(opTop);
                    break;
                }else{
                    output=output+opTop;
                }
            }
        }//end while
        infixStack.push(opThis);
    }

    public void gotParen(char ch){
        while (!infixStack.isEmpty()){
            char chx = infixStack.pop();
            if(chx=='(')
                break;
            else
                output=output+chx;
        }
    }

}
