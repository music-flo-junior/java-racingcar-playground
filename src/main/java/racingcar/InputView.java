package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return convertCarList(scanner.nextLine());
    }

    private static List<Car> convertCarList(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        String[] carNames = input.split(",");
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
