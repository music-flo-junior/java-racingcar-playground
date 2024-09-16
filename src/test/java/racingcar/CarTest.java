package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("name");
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getName()).isEqualTo("name");
    }

    @Test
    void 자동차_생성_이름_초과() {
        Assertions.assertThatThrownBy(() -> {
            new Car("nameover5");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_생성_빈이름() {
        Assertions.assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름이 존재하지 않습니다.");
    }

    @Test
    void 자동차_이동() {
        Car car = new Car("test");
        car.move(() -> true);
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차_이동_안함() {
        Car car = new Car("test");
        car.move(() -> false);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
