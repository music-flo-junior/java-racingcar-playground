package racingcar;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return this.name;
    }
}
