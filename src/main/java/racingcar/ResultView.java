package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PROGRESS_FORMAT = "-";

    private ResultView() {
    }

    public static void showResult(RacingGameResult result) {
        System.out.println("실행 결과");
        for (Round round : result.getRounds()) {
            showRound(round);
        }
        showWinner(result.getWinners());
    }

    private static void showRound(Round round) {
        Map<String, Integer> roundMap = round.getResult();
        for (ImmutableCar car : round.getCarList()) {
            System.out.println(car.getName() + " : " + progress(roundMap.get(car.getName())));
        }
        System.out.println();
    }

    private static String progress(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(PROGRESS_FORMAT);
        }
        return builder.toString();
    }

    private static void showWinner(List<String> winners) {
        String winnersResult = winners.stream().collect(Collectors.joining(", "));
        System.out.println(winnersResult + "가 최종 우승했습니다.");
    }
}
