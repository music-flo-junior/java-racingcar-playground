package racingcar;

import java.util.Objects;

public class ImmutableCar implements Comparable<ImmutableCar> {
    private final String name;
    private final int position;

    public ImmutableCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(ImmutableCar car) {
        return Integer.compare(car.getPosition(), this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableCar car = (ImmutableCar) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
