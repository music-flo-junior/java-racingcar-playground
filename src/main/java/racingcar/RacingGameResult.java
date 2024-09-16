package racingcar;

import java.util.List;

public class RacingGameResult {
    private final List<Round> rounds;

    public RacingGameResult(List<Round> rounds) {
        if (rounds == null || rounds.isEmpty()) {
            throw new IllegalStateException("게임 결과가 없습니다.");
        }
        this.rounds = rounds;
    }

    public List<String> getWinners() {
        return rounds.get(rounds.size() - 1).getWinners();
    }

    public List<Round> getRounds() {
        return this.rounds;
    }
}
