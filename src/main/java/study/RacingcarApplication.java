package study;

import study.racingcar.Car;
import study.racingcar.RacingCarConsoleView;
import study.racingcar.RacingCarView;
import study.racingcar.RacingGame;

import java.util.List;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/16
 */
public class RacingcarApplication {

    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarConsoleView();
        List<Car> cars = racingCarView.inputCars();
        int numberOfAttempt = racingCarView.inputNumberOfAttempt();
        RacingGame racingGame = new RacingGame(racingCarView, cars, numberOfAttempt);
        racingGame.start();
    }
}
