package calculator;

public class StringUtils {
    private static final String REGEX_NUMBER = "[0-9]+";

    private StringUtils() {
    }

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean isOnlyNumber(String text) {
        return text.matches(REGEX_NUMBER);
    }
}
