package arraylist;
import java.util.Scanner;
public class Inputter {
   public static Scanner sc = new Scanner(System.in);
   public static int inputInt(String mgs, int min, int max){
       if(min > max){
           int t = max;
           max = min;
           min = t;
       }
       int data;
       do{
           System.out.println(mgs);
           data = Integer.parseInt(sc.nextLine());
           
       }while(data<min || data >max);
       return data;
   }
    public static String inputStr(String msg){
    System.out.println(msg);
    String data = sc.nextLine().trim();
    return data;
    }
    public static String inputNonBlankStr(String msg){
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
        }while(data.length() == 0);
        return data;
    }
}
