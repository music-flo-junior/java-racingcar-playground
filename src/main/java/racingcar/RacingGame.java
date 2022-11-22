package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int count;
    private final List<Car> carList;
    private final List<Round> rounds;

    public RacingGame(int count, List<Car> carList) {
        this.count = count;
        this.carList = carList;
        this.rounds = new ArrayList<>();
        initStartRound();
    }

    public RacingGameResult startGameAndGetResult() {
        for (int i = 0; i < count; i++) {
            rounds.add(playOneRound());
        }

        return new RacingGameResult(rounds);
    }

    private void initStartRound() {
        rounds.add(Round.from(carList));
    }

    private Round playOneRound() {
        for (Car car : carList) {
            car.progress(RandomUtils.getRandomNumber(Car.MAX_BOUND));
        }
        return Round.from(carList);
    }

}
