package com.oleh.pakhomov;


import org.junit.Test;
import org.testfx.assertions.api.Assertions;


public class DivideMethodTest {
    @Test
    public void validateCalculations() {
        var result = Math.round(DivideMethod.findMin(new MathModel(-10, 10, 0.01, 0.3)));

        Assertions.assertThat(result).isEqualTo(-3L);
    }
}
