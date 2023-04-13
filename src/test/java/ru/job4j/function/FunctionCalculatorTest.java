package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-3, 2, x -> (x + 1) * (x + 1));
        List<Double> expected = Arrays.asList(4D, 1D, 0D, 1D, 4D);
        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(0, 3, x -> Math.pow(Math.E, x));
        List<Double> expected = Arrays.asList(1D, Math.E, Math.E * Math.E);
        assertThat(result).containsExactlyElementsOf(expected);
    }
}
