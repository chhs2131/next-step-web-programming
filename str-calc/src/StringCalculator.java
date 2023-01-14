import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//*\n";

    int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        // delimiters 생성
        Deliimiters delimiters = new Deliimiters(text);
        System.out.println(delimiters.toString());

        // int 리스트로 반환
        List<Integer> numbers = splitToIntList(text, delimiters);
        System.out.println(numbers);

        // 덧셈
        int result = sum(numbers);
        System.out.println(result);
        return result;
    }

    private List<Integer> splitToIntList(String text, Deliimiters delimiters) {
        String[] tokens = text.split(delimiters.getDelimitersPattern());

        List<Integer> result = new ArrayList<Integer>();
        for (String token : tokens) {
            System.out.println("token: " + token);
            try {
                result.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
            }
        }
        return result;
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
