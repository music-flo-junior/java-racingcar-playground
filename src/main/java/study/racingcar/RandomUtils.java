package study.racingcar;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/18
 */
public class RandomUtils {

    private RandomUtils() {
    }

    public static int getInt(int limit) {
        return ThreadLocalRandom.current().nextInt(limit);
    }
}
