package calculator;

import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class StringAddCalculator {

    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return 0;
        }

        if (inputText.length() == 1 && isPositiveNumber(inputText)) {
            return Integer.parseInt(inputText);
        }

        String[] tokens;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = inputText.split(",|:");
        }

        return addTokens(tokens);
    }

    private static int addTokens(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            if (isPositiveNumber(token)) {
                result += Integer.parseInt(token);
            }
        }
        return result;
    }

    public static boolean isPositiveNumber(String inputText) {
        int inputInt = Integer.parseInt(inputText);
        if (inputInt >= 0) {
            return true;
        } else {
            throw new RuntimeException();
        }
    }
}
