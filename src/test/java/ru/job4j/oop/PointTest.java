package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {

    @Test
    public void distance00to40Then4() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double expected = 4;
        assertThat(a.distance(b)).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void distance22to00Then2dot8284() {
        Point a = new Point(2, 2);
        Point b = new Point(0, 0);
        double expected = 2.8284;
        assertThat(a.distance(b)).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void distance3d222to000Then2dot8284() {
        Point a = new Point(2, 2, 2);
        Point b = new Point(0, 0, 0);
        double expected = 3.4641;
        assertThat(a.distance3d(b)).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void distance3d123to4615Thent13() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(4, 6, 15);
        double expected = 13;
        assertThat(a.distance3d(b)).isCloseTo(expected, offset(0.001));
    }
}
