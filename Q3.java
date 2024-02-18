import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.util.Stack;
//تحويل تعبير رياضي مكتوب بشكل هجائي (Infix) إلى تعبير مكتوب بشكل مقلوب (Postfix).
public class Q3 {
    public static int precedence(char x){

        if(x=='^'){
            return 2;
        }
        else if(x=='*' || x=='/'){
            return 1;
        }
        else if(x=='+' || x=='-'){

            return 0;
        }
        return -1;
    }

    public static String InfixToPostfix(String str){
        //تأخذ تعبيرًا رياضيًا هجائيًا (str) وتعيد نظيره المقلوب.
        //تستخدم مكدسًا (stk) للمساعدة في التحويل.
        Stack<Character>stk= new Stack<>();

        String ans="";

        int n= str.length();

        for (int i = 0; i <n ; i++) {
            char x= str.charAt(i);

            if(x>='0' && x<='9'){
                ans+=x;
            }

            else if(x=='('){
                stk.push('(');
            }
            else if(x==')'){

                while(!stk.isEmpty() && stk.peek()!='('){
                    ans+=stk.pop();
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }

            }
            else{

                while(!stk.isEmpty() && precedence(stk.peek())>=precedence(x)){
                    ans+=stk.pop();
                }
                stk.push(x);

            }
        }
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println( InfixToPostfix("5*(4+6)-6"));
    }

}
//إذا كان رقمًا، تضيفه مباشرة إلى النتيجة (ans).
//إذا كان قوسًا مفتوحًا (, تضعه مباشرة في المكدس.
//إذا كان قوسًا مغلقًا ), تستخرج رموزًا من المكدس وتضيفها إلى النتيجة حتى تعثر على القوس المفتوح المقابل، ثم تستخرجه أيضًا.
//إذا كان رمزًا رياضيًا (+, -, *, /, ^), تستخرج رموزًا من المكدس ذات أولوية مساوية أو أعلى وتضيفها إلى النتيجة، ثم تضع الرمز الحالي في المكدس.
//بعد معالجة كل الرموز، تستخرج جميع الرموز المتبقية من المكدس وتضيفها إلى النتيجة.
//تعيد دالة InfixToPostfix التعبير الرياضي المقلوب (
