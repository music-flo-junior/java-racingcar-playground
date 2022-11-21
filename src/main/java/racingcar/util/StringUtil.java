package racingcar.util;

public class StringUtil {

    public static String[] splitToArray(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return null;
        }
        return inputText.split(",");
    }
}
