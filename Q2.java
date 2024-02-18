//إضافة عناصر إلى المكدس.
//طباعة عناصر المكدس قبل عملية الحذف.
public class Q2 {
    public static void main(String[] args) {
        slinkedStak<Integer>list=new slinkedStak<>();

        list.push(11);
        list.push(12);
        list.push(13);
        list.push(14);
        list.print(list);
        System.out.println();
        System.out.print("the element deleted:  ");
        list= list.recursive(list);//تؤدي حذف بعض العناصر بطريقة عودية.
        System.out.println();
        list.print(list);
    }
}
