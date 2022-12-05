package racingcar.util;

public class NumberUtil {
    private static final int RANGE = 9;

    public static int createRandomNumber() {
        return (int) (Math.random() * RANGE); //0 ~ 9 사이
    }
}
