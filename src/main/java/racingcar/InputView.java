package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
        throw new IllegalStateException();
    }

    public static List<Car> getInputCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            return convertCarList(scanner.nextLine());
        }
        return Collections.emptyList();
    }

    private static List<Car> convertCarList(String carString) {
        return Arrays.stream(carString.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int getInputCount() {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        if (scanner.hasNextInt()) {
            count = scanner.nextInt();
        }
        return count;
    }
}
