import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deliimiters {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)*\n(.*)";
    private final List<String> delimiters;

    public Deliimiters(String text) {
        List<String> delimiters1 = null;
        String customDelimiter = Deliimiters.getCustomDelimiter(text);
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            delimiters1 = List.of(",", ":");
        }
        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            delimiters1 = List.of(",", ":", customDelimiter);
        }
        delimiters = delimiters1;
    }

    public Deliimiters() {
        delimiters = List.of(",", ":");
    }

    public String getDelimitersPattern() {
        return String.join("|", delimiters);
    }

    public static String getCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    @Override
    public String toString() {
        return "구분자: " + String.join(" ", delimiters);
    }
}
