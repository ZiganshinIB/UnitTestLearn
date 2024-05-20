package Calculator;

import Calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));


        // Проверка метода вычисления суммы покупки со скидкой и проверки исключений
        assertThat(Calculator.calculatingDiscount(100, 10)).isEqualTo(90);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-100, 10)
        ).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100000, 120)
        ).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(10000, -10)
        ).isInstanceOf(ArithmeticException.class);
    }
}