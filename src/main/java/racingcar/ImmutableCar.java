package racingcar;

import java.util.Objects;

public class ImmutableCar implements Comparable<ImmutableCar> {
    private final String name;
    private final int position;

    public ImmutableCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public ImmutableCar(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableCar that = (ImmutableCar) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(ImmutableCar car) {
        return Integer.compare(this.position, car.getPosition());
    }
}
