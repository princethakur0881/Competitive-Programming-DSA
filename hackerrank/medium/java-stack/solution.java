import java.io.*;
import java.util.*;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else {
                if(ch == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }

                if(ch == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }

                }

                if (ch == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }

                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
             System.out.println(isValid(input));
        }
       
        
    }
}


