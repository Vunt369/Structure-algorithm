package File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderWriter {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("src/File/f1.txt");
            out = new FileWriter("src/File/f2.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
