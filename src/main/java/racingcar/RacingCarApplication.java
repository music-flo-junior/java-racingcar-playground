package racingcar;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        List<Car> cars = InputView.getCars();
        int count = InputView.getCount();
        RacingGame racingGame = new RacingGame(cars, count);
        RacingGameResult result = racingGame.start();
        ResultView.showResult(result);
    }
}
