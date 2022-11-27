package study.racingcar;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2022/11/26
 */
public class RandomForwardable implements ForwardStrategy{

    private static final int FORWARD_MINIMUM_RULE_LIMIT = 4;

    private static final int FORWARD_MAXIMUM_RULE_LIMIT = 10;

    @Override
    public boolean forwardable() {
        return FORWARD_MINIMUM_RULE_LIMIT <= RandomUtils.getInt(FORWARD_MAXIMUM_RULE_LIMIT);
    }
}
