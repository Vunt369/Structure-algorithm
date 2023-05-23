package ArrayListString;

import java.util.ArrayList;

public class ArrayListString {

    public static void main(String[] args) {
        ArrayList animals = new ArrayList<String>();
//add
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bird");
        animals.add("Monkey");
//
        animals.remove(2);//remove Bird
//
        animals.add("Chicken");
        animals.add("Duck");
//contains() kiem tra mang co chua phan tu
        
        System.out.println(animals.contains("Bird"));
        System.out.println("=======================");
//get() lay phan tu co chi so index
        System.out.println(animals.get(4));
        System.out.println("=======================");
// size() lay so phan tu
        System.out.println(animals.size());
        System.out.println("=======================");
// toArray() chuyen thanh mang
        Object[] A = animals.toArray();
        for (Object i : A) {
            System.out.println(i);
        }
    }
}
