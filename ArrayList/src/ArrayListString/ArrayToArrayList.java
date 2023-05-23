package ArrayListString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayToArrayList {

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<String>();
        A.add("Java");
        A.add("Python");
        A.add("C++");
        A.add("Ruby");

        //convert ArrayList to Array
        System.out.println("convert ArrayList to Array");
        String[] B = A.toArray(new String[A.size()]);

        for (String i : B) {
            System.out.println(i);
        }

        // convert Array to ArrayList
        System.out.println("convert Array to ArrayList");
        List<String> list2 = new ArrayList<>();
        list2 = Arrays.asList(B);
        Iterator<String> C = list2.iterator();
        while (C.hasNext()) {
            System.out.println(C.next() + " ");
        }

    }
}
