package racingcar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class RacingCarGameResult {

    List<RacingCar> racingCars;
    String maxPosition;
    String championCarNamesStr;

    public RacingCarGameResult(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        this.maxPosition = findMaxPosition(racingCars);
        this.championCarNamesStr = createChampionCarNamesStr(racingCars);
    }

    private String findMaxPosition(List<RacingCar> racingCars) {
        AtomicReference<String> tempMaxPosition = new AtomicReference<>(racingCars.get(0).getPosition());

        racingCars.forEach(racingCar -> {
            if (tempMaxPosition.get().length() <= racingCar.getPosition().length()) {
                tempMaxPosition.set(racingCar.getPosition());
            }
        });

        return tempMaxPosition.get();
    }

    private String createChampionCarNamesStr(List<RacingCar> racingCars) {

        List<String> championCarNameList = racingCars.stream()
                .filter(racingCar -> racingCar.isSamePosition(this.maxPosition))
                .map(RacingCar::getName)
                .collect(Collectors.toList());

        if (championCarNameList.isEmpty()) {
            return null;
        }

        StringBuilder championCarNamesBuffer = new StringBuilder();
        for (int i = 0; i < championCarNameList.size(); i++) {
            championCarNamesBuffer.append(championCarNameList.get(i));
            if (i < (championCarNameList.size() - 1)) {
                championCarNamesBuffer.append(", ");
            }
        }

        return championCarNamesBuffer.toString();
    }

    @Override
    public String toString() {
        return "RacingCarGameResult{" +
                "racingCars=" + racingCars + "\n" +
                ", maxPosition='" + maxPosition + "\n" +
                ", championCarNamesStr='" + championCarNamesStr + '\'' +
                '}';
    }
}
