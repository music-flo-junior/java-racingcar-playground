package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameResult;
import racingcar.util.ResultView;
import racingcar.util.StringUtil;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRacingCarTest {

    @Mock
    RacingCar racingCar = new RacingCar();
    @Mock
    ResultView resultView = new ResultView();
    @Mock
    RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    public void splitToArray_null_또는_빈문자() {
        String[] result = StringUtil.splitToArray(null);
        assertThat(result).isEqualTo(null);

        result = StringUtil.splitToArray("");
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void splitToArray_쉼표구분자() {
        String[] result = StringUtil.splitToArray("1,2");
        assertThat(result).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    public void splitToArray_쉼표_또는_콜론_구분자() {
        String[] result = StringUtil.splitToArray("1,2:3");
        assertThat(result).isEqualTo(new String[]{"1", "2:3"});
    }

    @Test
    public void splitToArray_경주할_자동차_이름() {
        String[] result = StringUtil.splitToArray("hi,bye,hello");
        assertThat(result).isEqualTo(new String[]{"hi", "bye", "hello"});
    }

    @Test
    @DisplayName("경주할 자동차들 생성 테스트")
    public void createRacingCars() {
        List<RacingCar> racingCars = RacingCar.createRacingCars(new String[]{"hi", "bye", "hello"}, 5);

        assertThat(racingCars.get(0).getName()).isEqualTo("hi");
        assertThat(racingCars.get(0).getPosition()).isEqualTo("");
        assertThat(racingCars.get(0).getPositionHistory()).isEqualTo(new HashMap<>(5));
        assertThat(racingCars.get(2).getName()).isEqualTo("hello");
        assertThat(racingCars.get(2).getPosition()).isEqualTo("");
        assertThat(racingCars.get(2).getPositionHistory()).isEqualTo(new HashMap<>());
    }

    @Test
    @DisplayName("경주할 자동차들 제대로 달리는지 테스트 ")
    public void runRacingCar() {
        List<RacingCar> racingCars = RacingCar.createRacingCars(new String[]{"hi", "bye", "hello"}, 5);
        racingCars.get(0).runByAttemptCount();
        assertThat(racingCars.get(0).getPositionHistory().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("레이싱 결과 출력 테스트 ")
    public void printRacingResultPrint() {
        List<RacingCar> racingCars = RacingCar.createRacingCars(new String[]{"hi", "bye", "hello"}, 5);
        racingCarGame.racing(racingCars);
        RacingCarGameResult result = new RacingCarGameResult(racingCars);
        resultView.printResultView(result);
    }
}