import Threads.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 4; i++) {
            new Writer(i).start();
        }
    }
}
