package Utils;

import java.io.*;
import java.sql.Timestamp;
import java.util.Scanner;

public class Utils {

    public static void Divider(char symbol, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(symbol);
        }
        System.out.println(builder);
    }

    public static void SaveLogFile(String filename, String saveLine) {
        File logfile = new File(filename);
        try (FileWriter fileWriter = new FileWriter(logfile, true)) {
            fileWriter
                    .append(String.valueOf(new Timestamp(System.currentTimeMillis())))
                    .append(" : ")
                    .append(saveLine)
                    .append("\n");
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String ReadFile(String filename) {
        String result = "";
        File file = new File(filename);
        try (FileReader fileReader = new FileReader(filename)) {
            Scanner scanner = new Scanner(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
