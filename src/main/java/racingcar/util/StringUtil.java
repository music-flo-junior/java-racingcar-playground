package racingcar.util;

public class StringUtil {
    private static final String SPLIT_STRING = ",";

    public static String[] splitToArray(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return null;
        }
        return inputText.split(SPLIT_STRING);
    }
}
