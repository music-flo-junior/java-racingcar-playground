package study.racingcar;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/26
 */
@FunctionalInterface
public interface ForwardStrategy {

    boolean forwardable();
}
