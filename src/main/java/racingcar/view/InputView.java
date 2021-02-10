package racingcar.view;

import racingcar.domain.gamemanager.dto.GameManagerRequestDto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static GameManagerRequestDto inputFromUser() {
        String carNames = inputCarNames();
        String roundCount = inputRoundCount();
        return new GameManagerRequestDto(carNames, roundCount);
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    private static String inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
