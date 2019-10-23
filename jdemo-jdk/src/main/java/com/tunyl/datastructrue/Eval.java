package com.tunyl.datastructrue;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * @author create by Tunyl on 2019/10/18
 * @version 1.0
 */
public class Eval {
    public int evalRPN(String[] tokens){
        Stack<Integer> s = new Stack<>();
        String oper = "+-*/";
        for(int i=0; i<tokens.length;i++){
            if(!oper.contains(tokens[i])){
                s.push(Integer.parseInt(tokens[i]));
            }else{
                int temp = eval(s.pop(), s.pop(), tokens[i]);
                s.push(temp);
            }
        }
        return s.pop();
    }

    private int eval(Integer pop, Integer pop1, String token) {
        switch(token){
            case "+":
                return pop+pop1;
            case "-":
                return pop1-pop;
            case "*":
                return pop*pop1;
            case "/":
                return pop1/pop;
            default:
                throw new RuntimeException("eeror operation express");

        }
    }

    public static void main(String[] args) {
        Eval eval = new Eval();
        int result = eval.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println("result:"+result);
    }
}
