package study.racingcar;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/18
 */
public class RacingCarReferee {

    private final List<Car> cars;

    private final ForwardStrategy forwardStrategy;

    public RacingCarReferee(List<Car> cars, ForwardStrategy forwardStrategy) {
        this.cars = cars;
        this.forwardStrategy = forwardStrategy;
    }

    public List<Car> judge() {
        cars.stream()
                .filter(car -> isForward())
                .forEach(Car::forward);
        return cars;
    }

    public List<Car> getWinners() {

        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(toList());
    }

    private boolean isForward() {
        return forwardStrategy.forwardable();
    }

}
