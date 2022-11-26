package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {
    @Test
    void 라운드_초기화_테스트() {
        List<Car> list = Arrays.asList(new Car("nova"), new Car("jayce"), new Car("nora"));
        Round round = new Round(list);
        assertThat(round.getCarList()).hasSize(3);
        assertThat(round.getCarList().get(0).getName()).isEqualTo("nova");
        assertThat(round.getCarList().get(0).getPosition()).isEqualTo(1);
        assertThat(round.getCarList().get(1).getName()).isEqualTo("jayce");
        assertThat(round.getCarList().get(1).getPosition()).isEqualTo(1);
        assertThat(round.getCarList().get(2).getName()).isEqualTo("nora");
        assertThat(round.getCarList().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 라운드_승자_확인() {
        List<Car> list = Arrays.asList(
                new Car("nova", 2),
                new Car("jayce", 3),
                new Car("nora", 4));
        Round round1 = new Round(list);
        assertThat(round1.getCarList()).hasSize(3);
        assertThat(round1.getCarList().get(0).getName()).isEqualTo("nova");
        assertThat(round1.getCarList().get(0).getPosition()).isEqualTo(2);
        assertThat(round1.getCarList().get(1).getName()).isEqualTo("jayce");
        assertThat(round1.getCarList().get(1).getPosition()).isEqualTo(3);
        assertThat(round1.getCarList().get(2).getName()).isEqualTo("nora");
        assertThat(round1.getCarList().get(2).getPosition()).isEqualTo(4);

        assertThat(round1.getWinners()).hasSize(1);
        assertThat(round1.getWinners()).contains("nora");
    }
}
