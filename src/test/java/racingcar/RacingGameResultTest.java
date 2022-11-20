package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RacingGameResultTest {
    private RacingGameResult racingGameResult;

    @BeforeEach
    public void init() {
        racingGameResult = initRandomGameResult();
    }

    private RacingGameResult initRandomGameResult() {
        List<Round> rounds = new ArrayList<>();
        List<CarSnapshot> carList = new ArrayList<>();
        carList.add(new CarSnapshot("포르쉐", 1));
        carList.add(new CarSnapshot("람보르기니", 1));
        carList.add(new CarSnapshot("마세라티", 1));
        rounds.add(new Round(carList));

        List<CarSnapshot> round1 = new ArrayList<>();
        round1.add(new CarSnapshot("포르쉐", 1));
        round1.add(new CarSnapshot("람보르기니", 2));
        round1.add(new CarSnapshot("마세라티", 2));
        rounds.add(new Round(round1));

        List<CarSnapshot> round2 = new ArrayList<>();
        round2.add(new CarSnapshot("포르쉐", 2));
        round2.add(new CarSnapshot("람보르기니", 3));
        round2.add(new CarSnapshot("마세라티", 2));
        rounds.add(new Round(round2));

        return new RacingGameResult(rounds);
    }

    @Test
    void 일등으로_들어온_차인지_확인() {
        List<CarSnapshot> result = racingGameResult.getWinners();
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("람보르기니");
    }


}
