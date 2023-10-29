package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public void validateCarNamesInput(String carNamesInput) {
        validateInputIsNotEmpty(carNamesInput);
        validateInputDoesNotEndWithComma(carNamesInput);
        validateInputDoesNotContainSpace(carNamesInput);
        validateInputDoesNotContainContinuousComma(carNamesInput);

        List<String> carNamesSplit = Arrays.asList(carNamesInput.split(","));
        validateInputDoesNotContainDuplicate(carNamesSplit);
        validateInputIsNotOverLength(carNamesSplit);
    }

    private void validateInputIsNotEmpty(String carNamesInput) {
        if (carNamesInput.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있을 수 없습니다.");
        }
    }

    private void validateInputDoesNotEndWithComma(String carNamesInput) {
        if (carNamesInput.endsWith(",")) {
            throw new IllegalArgumentException("입력값은 쉼표로 끝날 수 없습니다.");
        }
    }

    private void validateInputDoesNotContainSpace(String carNamesInput) {
        if (carNamesInput.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateInputDoesNotContainDuplicate(List<String> carNamesSplit) {
        if (carNamesSplit.stream().distinct().count() != carNamesSplit.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 포함될 수 없습니다.");
        }
    }

    private void validateInputIsNotOverLength(List<String> carNamesSplit) {
        if (carNamesSplit.stream().anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateInputDoesNotContainContinuousComma(String carNamesInput) {
        if (carNamesInput.contains(",,")) {
            throw new IllegalArgumentException("입력값에 연속된 쉼표가 포함될 수 없습니다.");
        }
    }

}
