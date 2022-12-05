package racingcar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import racingcar.util.NumberUtil;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RacingCar {

    private final int MOVE_ABLE_MIN_COUNT = 4;

    private final String name;
    private Position position;

    public boolean isMoveAble() {
        return NumberUtil.createRandomNumber() >= MOVE_ABLE_MIN_COUNT;
    }

    public void moveForward() {
        position.moveForward();
    }
}
