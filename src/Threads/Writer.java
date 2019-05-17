package Threads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Writer extends Thread {
    private int number;
    private Random random = new Random();

    public Writer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Writer.writeInFile(number, getNextToWrite());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getNextToWrite() {
        switch (number) {
            case 1:
                int numberOfAlphabets = 'Z' - 'A' + 1;
                char nextChar = (char) (random.nextInt(numberOfAlphabets) + 'A');
                return nextChar + "";
            case 2:
                int randomNumber = random.nextInt(100) + 1;
                return randomNumber + "";
            case 3:
                char[] chars = {'!', '@', '#', '$', '%', '&', '*'};
                char randomChar = chars[random.nextInt(chars.length)];
                return randomChar + "";
        }
        return null;
    }

    private static synchronized void writeInFile(int writerNumber, String toWrite) {
        try {
            FileWriter fileWriter = new FileWriter("data.txt", true);
            if (toWrite != null) {
                fileWriter.write(toWrite);
                fileWriter.close();
                System.out.println(writerNumber + " wrote: \"" + toWrite + "\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
