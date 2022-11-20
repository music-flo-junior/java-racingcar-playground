package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<Round> rounds;
    private final List<CarSnapshot> winners;

    public RacingGameResult(List<Round> rounds) {
        this.rounds = rounds;
        this.winners = getFirstCars(rounds.get(rounds.size() - 1));
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public List<CarSnapshot> getWinners() {
        return winners;
    }

    private List<CarSnapshot> getFirstCars(Round lastRound) {
        int firstCarPosition = lastRound.getCarList().stream()
                .sorted(CarSnapshot::compareTo)
                .map(CarSnapshot::getPosition)
                .findFirst().orElseThrow(IllegalStateException::new);
        return lastRound.getCarList().stream()
                .filter(car -> firstCarPosition == car.getPosition())
                .collect(Collectors.toList());
    }

}
