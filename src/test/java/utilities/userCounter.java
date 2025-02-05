package utilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class userCounter {
    private static final String COUNTER_FILE = "userCounter.txt";

    public static String generateUniqueUser() {
        int counter = getCounterFromFile();
        String user = "487user" + counter;
        updateCounterInFile(counter + 1);
        return user;
    }

    private static int getCounterFromFile() {
        try {
            if (Files.exists(Paths.get(COUNTER_FILE))) {
                String counterValue = new String(Files.readAllBytes(Paths.get(COUNTER_FILE)));
                return Integer.parseInt(counterValue.trim());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 1; // Valoare implicită dacă fișierul nu există sau conținutul este invalid
    }

    private static void updateCounterInFile(int newCounter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            writer.write(String.valueOf(newCounter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}