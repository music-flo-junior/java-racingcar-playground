package racingcar.model;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class RacingCarGameResult {
    private final List<RacingCar> winners;
    private final List<Round> rounds;

    public RacingCarGameResult(List<Round> rounds) {
        this.winners = findWinners(rounds.get(rounds.size() - 1));
        this.rounds = rounds;
    }

    private List<RacingCar> findWinners(Round lastRound) {

        int maxPositionValue = findMaxPositionValue(lastRound.getPositionSnapshot());

        return lastRound.getPositionSnapshot().entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), maxPositionValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int findMaxPositionValue(Map<RacingCar, Integer> lastRoundPositionMap) {
        return Collections.max(lastRoundPositionMap.values());
    }
}
