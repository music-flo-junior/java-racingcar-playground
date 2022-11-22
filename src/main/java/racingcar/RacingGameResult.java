package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<Round> rounds;
    private final List<ImmutableCar> winners;

    public RacingGameResult(List<Round> rounds) {
        this.rounds = rounds;
        this.winners = initWinners(rounds.get(rounds.size() - 1));
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public List<ImmutableCar> getWinners() {
        return winners;
    }

    private List<ImmutableCar> initWinners(Round lastRound) {
        int winnerPosition = lastRound.getCarList().stream()
                .sorted(ImmutableCar::compareTo)
                .map(ImmutableCar::getPosition)
                .findFirst().orElseThrow(IllegalStateException::new);

        return lastRound.getCarList().stream()
                .filter(car -> winnerPosition == car.getPosition())
                .collect(Collectors.toList());
    }

}
