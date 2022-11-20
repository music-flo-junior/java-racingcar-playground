package racingcar;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        List<Car> inputCars = InputView.getInputCarList();
        int count = InputView.getInputCount();
        RacingGame racingGame = new RacingGame(count, inputCars);
        RacingGameResult result = racingGame.startGameAndGetResult();
        ResultView.showGame(result);
    }
}
