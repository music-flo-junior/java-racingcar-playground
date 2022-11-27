package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/19
 */
class RacingCarRefereeTest {

    private List<Car> cars;

    @BeforeEach
    void init() {
        cars = Arrays.asList(new Car("one"), new Car("two"), new Car("three"));
    }

    @Test
    @DisplayName("Winner 가져오는 테스트")
    void getWinnerTest() {
        RacingCarReferee racingCarReferee = new RacingCarReferee(cars, () -> true);
        assertThat(racingCarReferee.getWinners()).isNotEmpty();
    }

    @Test
    @DisplayName("심판이 제대로 전진 개수를 세는지 테스트")
    void forwardJudgeTest() {
        RacingCarReferee racingCarReferee = new RacingCarReferee(cars, () -> true);
        List<Car> cars = racingCarReferee.judge();
        assertThat(cars.stream()
                .allMatch(car -> car.getDistance() != 0)).isTrue();
    }

    @Test
    @DisplayName("심판이 제대로 전진하지 않은 개수를 세는지 테스트")
    void noForwardjudgeTest() {
        RacingCarReferee racingCarReferee = new RacingCarReferee(cars, () -> false);
        List<Car> cars = racingCarReferee.judge();
        assertThat(cars.stream()
                .allMatch(car -> car.getDistance() == 0)).isTrue();
    }
}
