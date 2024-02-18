import java.util.*;
//تقييم تعبير رياضي مكتوب بشكل مقلوب باستخدام(Stack).
public class Q6 {
    protected  static int evalPostfix(String express)
    {
        slinkedStak<Integer> st = new slinkedStak<>();//تنشئ مكدسًا (st) من نوع slinkedStak لتخزين الأعداد أثناء عملية التقييم.

        for(int i=0; i < express.length(); i++)//تفحص كل رمز في التعبير المقلوب
        {
            char ch = express.charAt(i);

            if(Character.isDigit(ch))
                st.push(ch - '0');

            else
            {//تستخرج آخر عددين من المكدس
                int value1 = st.pop();
                int value2 = st.pop();
//تنفذ العملية الحسابية حسب المُعامل.
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
        }//بعد معالجة جميع الرموز، تعيد الدالة القيمة النهائية الموجودة في أعلى المكدس.
        return st.pop();
    }
    public static void main(String[] args)
    {
        String express="432*+11-";//تحدد التعبير المقلوب المراد تقييمه
        System.out.println("Postfix evaluation of the given expression comes out to be :" +evalPostfix(express));
    }
}