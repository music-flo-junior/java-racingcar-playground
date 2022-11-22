package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private final List<ImmutableCar> carList;

    public Round(List<ImmutableCar> carList) {
        this.carList = carList;
    }

    public static Round from(List<Car> carList) {
        return new Round(carList.stream()
                .map(car -> new ImmutableCar(car.getName(), car.getPosition()))
                .collect(Collectors.toList()));
    }

    public List<ImmutableCar> getCarList() {
        return carList;
    }
}
