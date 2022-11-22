package racingcar;

public class Car {

    public static final int MIN_BOUND = 4;
    public static final int MAX_BOUND = 9;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progress(int bound) {
        if (bound >= MIN_BOUND) {
            position++;
        }
    }

}
