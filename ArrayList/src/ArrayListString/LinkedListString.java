
package ArrayListString;
import java.util.Iterator;
import java.util.LinkedList;
public class LinkedListString {
    public static void main(String[] args){
        LinkedList<String> PcLanguage = new LinkedList<String>();
        //add()
        PcLanguage.add("Java");
        PcLanguage.add("C++");
        PcLanguage.add("Python");
        PcLanguage.add("JavaStript");
        //Duyet phan tu bang Iterator
        Iterator<String> iter = PcLanguage.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + ", ");
        }
        System.out.println("\n===============");
        // add first
        PcLanguage.addFirst("Ngon ngu lap trinh");
        // add last
        PcLanguage.addLast("-het-");
        //show by for-each loop
        for(Object i : PcLanguage){
        System.out.println(i);    
        }
        System.out.println("===============");
        //FistNode - LastNode // Lay gia tri phan tu First and Last
        String firstNode = PcLanguage.getFirst();
        String lastNode = PcLanguage.getLast();
        System.out.println("First Node = " + firstNode);
        System.out.println("Last Node = " + lastNode);
        //update elements
        PcLanguage.set(2, "C");
        System.out.println("===============");
         for(Object i : PcLanguage){
        System.out.println(i);    
        }
        
    }
}
