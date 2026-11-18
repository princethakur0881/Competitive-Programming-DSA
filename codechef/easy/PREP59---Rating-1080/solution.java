import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
if(sc.hasNextInt()){
    int t = sc.nextInt();
    while(t-->0){
        String s = sc.next();
        System.out.println(isValidParenthesis(s)?1:0);
    }
}
}
static boolean isValidParenthesis(String s){
    Stack<Character> stack = new Stack<>();
    for(char c: s.toCharArray()){
        if(c=='('){
            stack.push(c);
        }else if(c==')'){
            if(stack.isEmpty()){
                return false;
            }
            stack.pop();
        }
    }

return stack.isEmpty();


	}
}
