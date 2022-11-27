package study.racingcar;

import java.util.List;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/18
 */
public class RacingGame {

    private final RacingCarView racingCarView;

    private final List<Car> cars;

    private final int numberOfAttempt;

    public RacingGame(RacingCarView racingCarView, List<Car> cars, int numberOfAttempt) {
        this.racingCarView = racingCarView;
        this.cars = cars;
        this.numberOfAttempt = numberOfAttempt;
    }

    public void start() {
        RacingCarReferee referee = new RacingCarReferee(cars, new RandomForwardable());
        racingCarView.printResultLabel();
        for (int i = 0; i < numberOfAttempt; i++) {
            racingCarView.print(referee.judge());
        }
        racingCarView.printWinners(referee.getWinners());
    }
}
