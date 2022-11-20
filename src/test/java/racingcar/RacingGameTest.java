package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    public void init() {
        racingGame = new RacingGame(5, initRacingCars());
    }

    @Test
    void 게임_플레이_랜덤() {
        // given
        RacingGameResult result = racingGame.startGameAndGetResult();
        List<CarSnapshot> winners = result.getWinners();
        ResultView.showGame(result);
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }

    private List<Car> initRacingCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("포르쉐"));
        carList.add(new Car("람보르기니"));
        carList.add(new Car("마세라티"));
        return carList;
    }
}
