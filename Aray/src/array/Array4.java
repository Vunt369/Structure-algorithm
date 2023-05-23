package array;
public class Array4 {
public static void main(String[] args){
    String s1 = "Nguyen Tuan";
String s2 = "Vu";
//Nối chuỗi
String s3 = s1 + s2; //cách 1
String s4 = s1.concat(s2);
System.out.println("s3 = " + s3);
System.out.println("s4 = " + s4);

//Hàm thay thế
String st1 = "Anh Vu";
String st2 = st1.replaceAll("Vu", "Tuấn Vũ");
System.out.println("st1 = " + st1);//Thay thế không làm thay dổi giá trị của st1;
System.out.println("st2 = " + st2);

//toLower, toUpper
//In hoa chuỗi st2
String st3 = st2.toUpperCase();
String st4 = st2.toLowerCase();
System.out.println("chuỗi st2 hiện tại: " + st2);
System.out.println("(toUpper)-st2 = " + st2);//2 hàm toUpper và toLower không làm thay đổi giá trị của chuỗi cũ
System.out.println("(toLOwer)-st3 = " + st3);

//trim() hàm cắt khoảng trắng ở đầu của chuỗi
String st5 = "         Vũ";
String st6 = st5.trim();
System.out.println("[trim()]-st6 = " + st6);
//substring() cắt chuỗi lớn thành chuỗi con
String A = "ABC DEF GHIKLM";
String A1 = A.substring(4); // Cắt từ vị trí thứ Ns+1
System.out.println("chuỗi A1 sau khi cắt là: " + A1);
String A2 = A.substring(0,4);//Cắt từ ban dầu đến N-1
System.out.println("Chuỗi A2(vị trí 0-4) là: "+ A2);
}
}
