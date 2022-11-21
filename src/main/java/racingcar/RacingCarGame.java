package racingcar;

import lombok.RequiredArgsConstructor;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameResult;
import racingcar.util.InputView;
import racingcar.util.ResultView;
import racingcar.util.StringUtil;

import java.util.List;

@RequiredArgsConstructor
public class RacingCarGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.play();
    }

    public void play() {
        boolean isRestart;
        do {
            inputView.printInputRacingCarNameView();

            // 경주할 자동차 이름 배열
            String[] racingCarNameArray = StringUtil.splitToArray(inputView.scanRacingCarName());

            // 시도 횟수
            int attemptCount = inputView.scanRacingCarGameAttemptCount();

            List<RacingCar> racingCars = RacingCar.createRacingCars(racingCarNameArray, attemptCount);

            this.racing(racingCars);

            RacingCarGameResult result = new RacingCarGameResult(racingCars);
            resultView.printResultView(result);

            isRestart = resultView.isRestart();
        } while (isRestart);
    }

    public void racing(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.runByAttemptCount();
        }
    }
}