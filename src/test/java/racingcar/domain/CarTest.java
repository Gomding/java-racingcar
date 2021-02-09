package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("경주할 자동차 이름 저장")
    public void getNameTest() {
        Car car = Car.of("bmw");

        assertThat(car).isEqualTo(Car.of("bmw"));
    }

    @ParameterizedTest(name = "양쪽끝 공백을 제거한 자동차 이름이 1자리 미만거나 5자리를 초과하면 RuntimeException이 발생(carName = {arguments})")
    @ValueSource(strings = {"", "abcdef", "  "})
    public void carNameLengthShouldNotBeUnderOneAndOverFive(String name) {
        assertThatThrownBy(() -> {
            Car.of(name);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름이 null이거나 빈문자일 경우에 IllegalArgumentException 발생")
    public void carNameShouldNotBeNullOrEmptyTest() {
        assertThatThrownBy(() -> {
            Car.of(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 4이상이면 자동차가 전진한다.")
    public void moveCarTest() {
        //given
        Car car = Car.of("test");
        int beforePosition = car.getPosition();

        //when
        car.tryToMove(4);

        //then
        assertThat(car).isEqualTo(Car.of("test", 1));
    }
}
