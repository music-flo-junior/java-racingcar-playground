package racingcar.util;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameResult;
import racingcar.model.Round;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {
    private static final String POSITION_STRING = "-";

    private final Scanner sc = new Scanner(System.in);

    public void printResultView(RacingCarGameResult result) {

        System.out.println("\n실행 결과");

        result.getRounds().forEach(this::printRacingRound);

        System.out.println("\n" + result.getWinners().stream().map(RacingCar::getName).collect(Collectors.joining(",")) + "가 최종 우승했습니다.\n");
    }

    private void printRacingRound(Round round) {
        Map<RacingCar, Integer> positionSnapshot = round.getPositionSnapshot();
        System.out.println();
        new ArrayList<>(positionSnapshot.keySet())
                .forEach(racingCar -> System.out.println(racingCar.getName() + " : " + POSITION_STRING.repeat(positionSnapshot.get(racingCar))));
    }

    public boolean isRestart() {

        System.out.println("============ 게임 종료 ============");

        System.out.println("경주를 새로 시작하려면 0, 종료하려면 1를 입력하세요.");

        int restartInput = sc.nextInt();

        while (restartInput != 0 && restartInput != 1) {
            System.out.println("다시 입력해주세요");
            restartInput = sc.nextInt();
        }

        return restartInput == 0;
    }
}