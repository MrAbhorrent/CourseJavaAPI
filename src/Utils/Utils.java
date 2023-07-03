package Utils;

public class Utils {

    public static void Divider(char symbol, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(symbol);
        }
        System.out.println(builder);
    }
}
