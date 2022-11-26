package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Round {
    private final List<ImmutableCar> carList;

    public Round(List<Car> carList) {
        if (carList == null || carList.isEmpty()) {
            throw new IllegalStateException("라운드는 비어있을 수 없습니다.");
        }
        this.carList = carList.stream().map(ImmutableCar::new).
                collect(Collectors.toList());
    }

    public List<ImmutableCar> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public Map<String, Integer> getResult() {
        return carList.stream()
                .collect(Collectors.toMap(ImmutableCar::getName, ImmutableCar::getPosition));
    }

    public List<String> getWinners() {
        int winnerPosition = getWinnersPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(ImmutableCar::getName)
                .collect(Collectors.toList());
    }

    private int getWinnersPosition() {
        return carList.stream()
                .max(ImmutableCar::compareTo)
                .orElseThrow(IllegalStateException::new)
                .getPosition();
    }
}
