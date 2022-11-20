package racingcar;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private RandomUtils() {
        throw new IllegalStateException();
    }

    public static int getRandomNumber(int bound) {
        Random random = ThreadLocalRandom.current();
        return random.nextInt(bound);
    }
}
