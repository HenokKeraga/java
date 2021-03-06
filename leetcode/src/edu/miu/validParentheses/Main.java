package edu.miu.validParentheses;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(isValid("()"));

    }
    public static boolean isValid(String s) {

        Stack stack=new Stack();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')' || ch=='}' || ch==']'){
                if(stack.empty())
                    return false;
                char pop=(char)stack.pop();
                if(ch==')'&& pop!='(')
                    return false;
                else if(ch=='}'&&pop!='{')
                    return false;
                else if(ch==']'&& pop!='[')
                    return false;

            }else{
                stack.push(ch);
            }
        }

        if(stack.empty()){
            return true;
        }
        return false;
    }
}
