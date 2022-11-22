package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    void 라운드_복사_테스트() {
        List<ImmutableCar> carList = new ArrayList<>();
        carList.add(new ImmutableCar("포르쉐", 1));
        carList.add(new ImmutableCar("람보르기니", 2));
        carList.add(new ImmutableCar("마세라티", 2));
        Round round = new Round(carList);
        Round round2 = new Round(round.getCarList());

        assertThat(round2.getCarList()).hasSize(round.getCarList().size());
        for (int i = 0; i < carList.size(); i++) {
            assertThat(round2.getCarList().get(i)).isEqualTo(round.getCarList().get(i));
        }
    }
}
