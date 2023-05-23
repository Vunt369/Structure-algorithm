package array;

public class Array2 {

    public static void main(String[] args) {
        String s1 = "nguyen";
        String s2 = "Nguyen";
        String s3 = "nguyen";
        //equals() : so sanh 2 chuoi,co phan biet in hoa-chu thuong
        System.out.println("s1 = s2:" + s1.equals(s2));
        System.out.println("s1 = s3:" + s1.equals(s3));

        //equalsIgnoreCase() : so sanh, k phan biet chu hoa
        System.out.println("s1 = s2:" + s1.equalsIgnoreCase(s2));
        System.out.println("s1 = s3:" + s1.equalsIgnoreCase(s3));

        //compareTo => so sanh, co phan biet chu hoa(ascii o chữ cái đầu khác nhau của 2 chuỗi)
        String st1 = "Nguyen Tuan A";
        String st2 = "Nguyen Tuan B";
        String st3 = "Nguyen Tuan a";
        String st4 = "Nguyen Tuan ";

        System.out.println("St1 vs St2 = " + st1.compareTo(st2));
        System.out.println("st1 vs st3 = " + st1.compareTo(st3));
        System.out.println("st1 vs st4 = " + st1.compareTo(st4));
        //compareToIgnoreCase() =>so sanh, ko phan biet chu hoa
        System.out.println("st1 vs st3(compareToIgnoreCase) = " + st1.compareToIgnoreCase(st3));
        
        //regionMatches() : so sanh 1 doan
        String r1 = "ntVU.com";
        String r2 = "VU.CC";
        boolean check = r1.regionMatches(2, r2, 0, 2);
        System.out.println(check);
        
        //starWith() => Hàm kiểm tra chuỗi bắt đầu bằng 
        String ss1 = "Nguyễn Văn A";
        String ss2 = "Trần Thị B";
        
        if(ss2.startsWith("Nguyễn")){
            System.out.println("Dòng họ: Nguyễn");
        }else{
            System.out.println("Dòng họ: Trần");
        }
        //endWith() : Hàm kiểm tra chuỗi kết thúc bởi ...
        String file1 = "VU.txt";
        String file2 = "VU.jpg";
        if(file2.endsWith(".txt")){
           System.out.println("File văn bản");
           
        }else{
            System.out.println("File hình ảnh");
        }
            
    }
}
