package racingcar;

import lombok.RequiredArgsConstructor;
import racingcar.model.Position;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameResult;
import racingcar.model.Round;
import racingcar.util.InputView;
import racingcar.util.ResultView;
import racingcar.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RacingGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void play() {
        boolean isRestart;

        do {

            inputView.printInputRacingCarNameView();

            // 경주할 자동차 이름 배열
            String[] racingCarNameArray = StringUtil.splitToArray(inputView.scanRacingCarName());

            // 시도 횟수
            int attemptCount = inputView.scanRacingCarGameAttemptCount();

            List<RacingCar> racingCars = initRacingCars(racingCarNameArray);

            RacingCarGameResult result = new RacingCarGameResult(runRounds(attemptCount, racingCars));

            resultView.printResultView(result);

            isRestart = resultView.isRestart();

        } while (isRestart);
    }

    private List<Round> runRounds(int attemptCount, List<RacingCar> racingCars) {
        List<Round> rounds = new ArrayList<>(attemptCount);

        Round initRound = new Round();
        initRound.init(racingCars);
        rounds.add(initRound);

        for (int i = 0; i < attemptCount; i++) {
            Round round = new Round();
            round.run(racingCars);
            rounds.add(round);
        }

        return rounds;
    }

    private List<RacingCar> initRacingCars(String[] racingCarNameArray) {
        List<RacingCar> racingCars = new ArrayList<>(racingCarNameArray.length);

        for (String racingCarName : racingCarNameArray) {
            RacingCar racingCar = new RacingCar(racingCarName, new Position());
            racingCars.add(racingCar);
        }

        return racingCars;
    }
}