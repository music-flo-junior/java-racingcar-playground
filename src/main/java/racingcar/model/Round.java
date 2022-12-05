package racingcar.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Round {

    private final Map<RacingCar, Integer> positionSnapshot;

    public Round() {
        this.positionSnapshot = new HashMap<>();
    }

    public void run(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            if (racingCar.isMoveAble()) {
                racingCar.moveForward();
            }
            positionSnapshot.put(racingCar, racingCar.getPosition().getPositionValue());
        });
    }

    public void init(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            racingCar.moveForward();
            positionSnapshot.put(racingCar, racingCar.getPosition().getPositionValue());
        });
    }
}
