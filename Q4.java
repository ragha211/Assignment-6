//يُنشئ مكدسين ويضيف عناصر إلى أحدهما ثم ينسخ محتوياته إلى الآخر بطريقة مستقلة.
public class Q4 {
    public static void main(String[] args) {
        ArrayStack<Integer>list=new ArrayStack<>();
        ArrayStack<Integer>list1=new ArrayStack<>();

        list.push(11);
        list.push(12);
        list.push(13);
        list.push(14);
        System.out.print("list1: ");
        list.print(list);
        list1= list1.clone(list);//يتم استدعاء دالة clone(list) على المكدس list وتخزين النتيجة في المكدس list1.
        System.out.print("\nlist2: ");
        list1.print(list1);
        System.out.print("\nlist1: ");
        list.print(list);

    }
}
