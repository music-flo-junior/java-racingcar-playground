package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RacingGameTest {
    @Test
    void 레이싱게임_동작_테스트() {
        List<Car> list = Arrays.asList(
                new Car("nova"),
                new Car("jayce"),
                new Car("nora"));
        int count = 3;
        RacingGame racingGame = new RacingGame(list, count);

        RacingGameResult result = racingGame.start();
        Assertions.assertThat(result.getRounds()).hasSize(4); // 초기화 라운드 추가

        Assertions.assertThat(result.getWinners()).isNotEmpty();
        System.out.println(result.getWinners());
    }

}
