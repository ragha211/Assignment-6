//يُعرّف الكود فئةً تُسمى slinkedStak لتنفيذ بنية البيانات(Stack)
// باستخدام(single-linked list).
public class slinkedStak <E> implements Stack<E>{
    singleLinkedList<E>list=new singleLinkedList<>();

    public void printListreverse(slinkedStak<E>list){
        slinkedStak<E>l=new slinkedStak<>();

        while (!list.isEmpty()) {
            l.push(list.pop());
        }
        while (!l.isEmpty()){

            list.push(l.pop());
            System.out.print(list.top()+"  ");
        }
    }
    public void print(slinkedStak<E>list){
        slinkedStak<E>l=new slinkedStak<>();

        while (!list.isEmpty()) {
            System.out.print(list.top()+"  ");
            l.push(list.pop());


        }
        while (!l.isEmpty()){

            list.push(l.pop());

        }
    }
    protected static int evalPostfix(String express)
    {
        slinkedStak<Integer> st = new slinkedStak<>() {

        };

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

    public slinkedStak<E> recursive(slinkedStak<E>list){
        print(list);
        list=new slinkedStak<>();

        return list;
    }
    public  static<E> E popBottom(slinkedStak<E>list){

        slinkedStak<E>l=new slinkedStak<>();
        tansfer(list,l);
        E bottom=l.pop();
        tansfer(l,list);
        return bottom;
    }
    public   E bottom() {

        slinkedStak<E> l = new slinkedStak<>();

        while (!isEmpty()) {
            l.push(pop());
        }
        E bottom =  l.top();
        while (!l.isEmpty()) {
            push( l.pop());
        }
        return bottom;
    }
    public  static <E>  void tansfer(slinkedStak<E>l,slinkedStak<E>l1){
        while (!l.isEmpty()) {
            l1.push(l.pop());
        }
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public void  push(E e) {
        list.addFirst(e);
    }
    @Override
    public E pop() {
        return list.removeFirst();
    }
}