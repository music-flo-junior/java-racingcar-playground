package racingcar.util;

import java.util.Scanner;

public class InputView {
    public void printInputRacingCarNameView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public String scanRacingCarName() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        while (inputString == null || inputString.isEmpty()) {
            System.out.println("경주할 자동차 이름을 잘못 입력하셨습니다.");
            System.out.println("다시 입력해주세요 : ");
            inputString = sc.nextLine();
        }

        return inputString;
    }

    public int scanRacingCarGameAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요? : ");

        Scanner sc = new Scanner(System.in);
        int inputInt = sc.nextInt();

        while (inputInt <= 0) {
            System.out.println("시도할 회수를 잘못 입력하셨습니다.");
            System.out.println("다시 입력해주세요 : ");
            inputInt = sc.nextInt();
        }

        return inputInt;
    }
}
