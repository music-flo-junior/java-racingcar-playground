package racingcar;

public class Car {
    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this(new CarName(name), new CarPosition());
    }

    public Car(String name, Integer position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position.move();
        }
    }

    public void move() {
        if (RandomMove.getInstance().movable()) {
            this.position.move();
        }
    }
}
