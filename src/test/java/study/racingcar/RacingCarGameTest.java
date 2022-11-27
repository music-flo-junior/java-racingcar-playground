package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/26
 */
class RacingCarGameTest {

    private List<Car> cars;

    @BeforeEach
    void init() {
        cars = Arrays.asList(new Car("one"), new Car("two"), new Car("three"));
    }

    @Test
    @DisplayName("레이싱 카 게임 테스트")
    void startGameTest() {
        RacingGame racingGame = new RacingGame(new RacingCarConsoleView(), cars, 5);
        racingGame.start();
    }
}
