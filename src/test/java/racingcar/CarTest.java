package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_초기화_테스트() {
        Car car = new Car("포르쉐");
        Assertions.assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void 자동차_전진하지_않는경우() {
        Car car = new Car("포르쉐");
        car.progress(Car.MIDDLE_BOUND - 1);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_전진하는_경우() {
        Car car = new Car("포르쉐");
        car.progress(Car.MAX_BOUND - 1);
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }

}
