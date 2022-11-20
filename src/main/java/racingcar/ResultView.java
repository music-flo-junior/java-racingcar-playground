package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException();
    }

    public static void showGame(RacingGameResult result) {
        System.out.println("실행 결과");

        for (Round round : result.getRounds()) {
            showRound(round);
        }
        showWinners(result.getWinners());
    }

    private static void showRound(Round round) {
        for (CarSnapshot car : round.getCarList()) {
            System.out.println(convertCarResult(car));
        }
        System.out.println();
    }

    private static String convertCarResult(CarSnapshot car) {
        return String.format("%s : %s", car.getName(), convertPositionToString(car.getPosition()));
    }

    private static String convertPositionToString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    private static void showWinners(List<CarSnapshot> winners) {
        String winnerString = winners.stream().map(CarSnapshot::getName).collect(Collectors.joining(", "));
        System.out.println(winnerString + "가 최종 우승했습니다.");
    }
}
