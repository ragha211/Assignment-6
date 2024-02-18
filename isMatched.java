//يحدد الكود ما إذا كانت الأقواس والزوايا في تعبير متطابقة أم لا.
public class isMatched {
    public static boolean isMatched(String expression) {//فئة isMatched: تحتوي على دوال للتحقق من التطابق.
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new slinkedStak<>( );
        for (char c : expression.toCharArray( )) {//تتحقق من كل حرف في التعبير
            if (opening.indexOf(c) != -1)
                buffer.push(c);
            else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty( ))//تتحقق من كون المكدس فارغًا
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop( )))//تطابقه مع العنصر العلوي في المكدس
                    return false;
            }
        }
        return buffer.isEmpty( );
    }

    public static void main(String[] args) {
        System.out.println(  isMatched("(())"));
    }

}
