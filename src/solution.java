import java.util.*;
class Solution {
    public boolean isValid(String s) {
        char[] parantheses = new char[6];
        parantheses[0] = '(';
        parantheses[1]  =')';
        parantheses[2] = '[';
        parantheses[3] = ']';
        parantheses[4] = '{';
        parantheses[5] = '}';
        //System.out.println(parantheses[0]);
        /*int p0 =0,p2=0, p1=0,p3=0,p4=0,p5=0, pairs =0;
        for(int i=0; i< s.length()-1; i++){
            if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){
                p0++;
                i++;
                pairs++;
            }
            else if(s.charAt(i) == '[' && s.charAt(i+1) == ']'){
                p2++;
                i++;
                pairs++;
            }
            else if(s.charAt(i) == '{' && s.charAt(i+1) == '}'){
                p4++;
                i++;
                pairs++;
            }
        }
        if(pairs == s.length()/2)
            return true;
        else
            return false;

        /*if(((p0>0)&& (p0)%2 ==0) || ((p2>0) && ((p2)%2 ==0)) || ((p4> 0) && ((p4)%2==0)))
            return true;
        else
            return false;

        //try in recursive
        switch(s.charAt(i)) {
            case '(':
                if( !stack.isEmpty() && stack.pop() == '(') {
                    pair++;
                }
                else
                    stack.push(s.charAt(i));
                break;
            case '}':
                if(!stack.isEmpty() && stack.pop == '{'){
                    pair++;
                }
                else
                    stack.push(s.charAt(i));
                break;
            case']':
                if(!stack.isEmpty() && stack.pop() == '['){
                    pair++;
                }
                else
                    stack.push(s.charAt(i));
                break;

        }
        // using stack
        */
        Stack<Character> stack = new Stack<Character>();
        if(s.length()==1) return false;

        int pair=0;
        for (int i=0;i< s.length(); i++){
            if(s.charAt(i)=='(' ||s.charAt(i)=='{' ||s.charAt(i)=='[' ){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)== ')'){
                if(!stack.isEmpty() && stack.peek() =='('){
                    stack.pop();
                }
            }
            else if( s.charAt(i)== '}'){
                if(!stack.isEmpty() && stack.peek() =='{'){
                    stack.pop();
                }
            }
            else if(s.charAt(i)== ']'){
                if(!stack.isEmpty() && stack.peek() =='['){
                    stack.pop();
                }
            }
            else{
                stack.push(s.charAt(i));
            }

        }
        if(stack.isEmpty())
            return true;
        else
            return false;

    }
}


