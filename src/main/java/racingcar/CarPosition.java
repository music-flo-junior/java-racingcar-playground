package racingcar;

import java.util.Objects;

public class CarPosition {
    private static final int DEFAULT_POSITION = 1;
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition() {
        this(DEFAULT_POSITION);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public void move() {
        this.position++;
    }
}
