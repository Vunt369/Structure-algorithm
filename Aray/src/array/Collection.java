package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Collection {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        Iterator<String> isKey = hashMap.keySet().iterator();
        while (isKey.hasNext()) {
            System.out.println(isKey.next());
        }

        Iterator<Integer> isValue = hashMap.values().iterator();
        System.out.println("Value is");
        while (isValue.hasNext()) {
            System.out.println(isValue.next());
        }
        
        Iterator<HashMap.Entry<String, Integer>> all = hashMap.entrySet().iterator();
        while(all.hasNext()){
            System.out.println(all.next());
        }
        
        System.out.println("Gia tri phan tu theo key la: " + hashMap.get("two"));
    }

}
