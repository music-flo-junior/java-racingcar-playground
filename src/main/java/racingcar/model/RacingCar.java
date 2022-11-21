package racingcar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import racingcar.util.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RacingCar {

    String name;
    String position;
    Map<Integer, String> positionHistory;

    int attemptCount;

    public static List<RacingCar> createRacingCars(String[] racingCarNameArray, int attemptCount) {
        List<RacingCar> racingCars = new ArrayList<>(racingCarNameArray.length);
        for (String racingCarName : racingCarNameArray) {
            RacingCar racingCar = new RacingCar(racingCarName, "", new HashMap<>(attemptCount), 5);
            racingCars.add(racingCar);
        }
        return racingCars;
    }

    public void runByAttemptCount() {
        for (int i = 0; i < this.attemptCount; i++) {
            if (isIncreasePosition()) {
                this.position = this.position + "-";
            }
            this.positionHistory.put(i, this.position);
        }
    }

    public boolean isSamePosition(String maxPosition) {
        return this.position.equals(maxPosition);
    }

    private boolean isIncreasePosition() {
        return NumberUtil.createRandomNumber() >= 4;
    }

}
