package calculator;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException() {
        super("잘못된 형식의 숫자입니다.");
    }
}
