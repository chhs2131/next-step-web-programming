import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//*\n";

    int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += toPositive(value);
        }
        return sum;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 안되요~");
        }
        return number;
    }
}
