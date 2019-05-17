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
        while (true) {
            writeInFile();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeInFile() {
        String toWrite = getNextToWrite();
        // TODO: 5/17/19
        System.out.println("I wrote: \"" + toWrite + "\"");
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
}
