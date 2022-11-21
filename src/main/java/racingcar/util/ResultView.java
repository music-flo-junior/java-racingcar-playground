package racingcar.util;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameResult;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    public void printResultView(RacingCarGameResult result) {

        System.out.println("\n실행 결과");

        List<RacingCar> racingCars = result.getRacingCars();
        int attemptCount = racingCars.get(0).getAttemptCount();

        for (int i = 0; i < attemptCount; i++) {
            for (RacingCar racingCar : racingCars) {
                System.out.print(racingCar.getName() + " : " + racingCar.getPositionHistory().get(i) + "\n");
            }
            System.out.println();
        }

        if (result.getChampionCarNamesStr() == null) {
            System.out.println("\n최종 우승자가 존재하지 않습니다.\n");
        } else {
            System.out.println("\n" + result.getChampionCarNamesStr() + "가 최종 우승했습니다.\n");
        }
    }

    public boolean isRestart() {

        System.out.println("============ 게임 종료 ============");

        System.out.println("경주를 새로 시작하려면 0, 종료하려면 1를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        int restartInput = sc.nextInt();

        while (restartInput != 0 && restartInput != 1) {
            System.out.println("다시 입력해주세요");
            restartInput = sc.nextInt();
        }

        return restartInput == 0;
    }
}