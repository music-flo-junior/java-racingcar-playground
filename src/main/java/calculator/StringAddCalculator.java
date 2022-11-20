package calculator;

public class StringAddCalculator {
    private static final String SPLIT_REGEX = ",|:";
    private static final String PREFIX_CUSTOM_SEPARATOR_REGEX = "//(.)\\n(.*)";

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        if (StringUtils.isOnlyNumber(text)) {
            return Integer.parseInt(text);
        }

        if (isCustomSeparator(text)) {
            return getSplitTextAndSum(getStringByCustomSeparator(text), getCustomSeparator(text));
        }
        return getSplitTextAndSum(text, SPLIT_REGEX);
    }

    private static int getSplitTextAndSum(String text, String split) {
        String[] numbers = text.split(split);
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new RuntimeException();
            }
            sum += num;
        }
        return sum;
    }

    private static boolean isCustomSeparator(String text) {
        return text.matches(PREFIX_CUSTOM_SEPARATOR_REGEX);
    }

    private static String getCustomSeparator(String text) {
        return text.substring(2, 3);
    }

    private static String getStringByCustomSeparator(String text) {
        return text.substring(4);
    }

}
