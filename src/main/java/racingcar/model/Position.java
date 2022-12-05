package racingcar.model;

import lombok.Getter;

@Getter
public class Position {
    private int positionValue = 0;

    public void moveForward() {
        this.positionValue++;
    }
}
