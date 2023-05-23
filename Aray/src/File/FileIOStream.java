package File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream input = null;
        FileOutputStream output = null;
        int c;
        try {
            input = new FileInputStream("src/File/f1.txt");
            output = new FileOutputStream("src/File/f2.txt");
            while ((c = input.read()) != -1) {
                output.write(c);
                
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }

}
