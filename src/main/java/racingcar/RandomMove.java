package racingcar;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMove implements MoveStrategy {
    private static final RandomMove instance = new RandomMove();
    private static final int MIN_BOUND = 4;
    private static final int MAX_BOUND = 9;

    private RandomMove() {
    }

    public static RandomMove getInstance() {
        return instance;
    }

    @Override
    public boolean movable() {
        Random random = ThreadLocalRandom.current();
        return random.nextInt(MAX_BOUND) >= MIN_BOUND;
    }
}
