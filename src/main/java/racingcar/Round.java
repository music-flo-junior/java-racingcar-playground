package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private final List<CarSnapshot> carList;

    public Round(List<CarSnapshot> carList) {
        this.carList = carList;
    }

    public static Round from(List<Car> carList) {
        return new Round(carList.stream()
                .map(car -> new CarSnapshot(car.getName(), car.getPosition()))
                .collect(Collectors.toList()));
    }

    public List<CarSnapshot> getCarList() {
        return carList;
    }
}
