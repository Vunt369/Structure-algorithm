package array;
import java.util.Scanner;
public class Array1 {
    public static void main(String[] args) {
      String s;
      Scanner sc = new Scanner(System.in); 
      System.out.println("Input string: ");
      s = sc.nextLine();
      //length
      System.out.println("do dai chuoi: " + s.length());
      //charAt lay ki tu lai vi tri
      for(int i =0; i<s.length();i++){
         if(s.charAt(i) == 'a'){
              System.out.println("Index "+i+" is: "+s.charAt(i));
          }
      }
     //getchar
     char arr[] = new char[10];
     s.getChars(2, 5, arr, 0);
     System.out.println(arr);
      //getByte lấy giá trị của các ký tự trong mảng 
      byte arrayByte[] = s.getBytes();
      for(byte b : arrayByte){
          System.out.println(b);
      }
     
    }
   
}
