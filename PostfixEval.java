import java.util.*;
import java.util.Stack;
//تقييم تعبير رياضي مكتوب بشكل مقلوب باستخدام(Stack)وطباعته العنصر الموجود في أعلى المكدس.
public class PostfixEval
{
    protected  static int evalPostfix(String express)
    {
        slinkedStak<Integer> st = new slinkedStak<>() ;

        for(int i=0; i < express.length(); i++)
        {
            char ch = express.charAt(i);

            if(Character.isDigit(ch))
                st.push(ch - '0');

            else
            {
                int value1 = st.pop();
                int value2 = st.pop();

                switch(ch)
                {
                    case '+':
                        st.push(value2 + value1);
                        break;

                    case '-':
                        st.push(value2 - value1);
                        break;

                    case '*':
                        st.push(value2*value1);
                        break;
                    case '/':
                        st.push(value2/value1);
                        break;
                }
            }
        }
        System.out.println(st.top());
        return st.pop();
    }

    public static void main(String[] args)
    {
        String express="242+*";
        //تستدعي دالة evalPostfix لتقييم التعبير وطباعته القيمة الموجودة في أعلى المكدس.
        System.out.println("Postfix evaluation of the given expression comes out to be :" +evalPostfix(express));
    }
}