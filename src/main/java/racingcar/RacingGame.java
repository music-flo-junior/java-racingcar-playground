package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int count;
    private final List<Round> rounds;

    public RacingGame(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
        this.rounds = new ArrayList<>();
        recordRound();
    }

    public RacingGameResult start() {
        for (int i = 0; i < count; i++) {
            playOneRound();
            recordRound();
        }

        return new RacingGameResult(rounds);
    }

    private void recordRound() {
        rounds.add(new Round(cars));
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.move(RandomMove.getInstance());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }
}
