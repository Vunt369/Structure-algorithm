package array;
public class Array3 {
    public static void main(String[] args) {
        String s1 = "Tuấn Vũ, tôi là tuấn 1 vũ, Tuấn Vũ xin chào!";
        String s2 = "Tuấn Vũ";
        String s3 = "tuấn 1";
        //indexOf() tìm kiếm chuỗi A trong một chuỗi nào đó, nếu có sẽ trả về
        System.out.println("Vị trí của s2 trong s1: "+ s1.indexOf(s2));
        System.out.println("Vị trí của s3 trong s1: "+ s1.indexOf(s3));
        
        //indexOf(str,index) tìm kiếm bắt đầu từ index
        System.out.println("Vị trí của s2 trong s1: "+ s1.indexOf(s2,5));
        System.out.println("Vị trí của s3 trong s1: "+ s1.indexOf(s3,12));
        //indexOf(str,char) tìm kiếm với ký tự
        char c1 = 't';
        System.out.println("Vị trí của c1 trong s1: "+ s1.indexOf(c1));
        System.out.println("Vị trí của c1 trong s1: "+ s1.indexOf(c1,30));
        
    }
    
}
