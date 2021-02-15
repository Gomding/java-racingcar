package racingcar.validator;

public class RoundValidator {
    private static final int MIN_COUNT_SIZE = 1;

    private RoundValidator() {
    }

    public static void validate(String inputCount) {
        validateInteger(inputCount);
        validateRoundCount(Integer.parseInt(inputCount));
    }

    private static void validateInteger(String inputCount) {
        try {
            Integer.parseInt(inputCount);
        } catch (NumberFormatException ne) {
            throw new NumberFormatException("시도할 횟수는 숫자여야 합니다.(입력가능범위 : 1 ~ 2147483647)");
        }
    }

    private static void validateRoundCount(int count) {
        if (count < MIN_COUNT_SIZE) {
            throw new IllegalArgumentException("시도할 횟수는 1이상 이어야 합니다.");
        }
    }
}
