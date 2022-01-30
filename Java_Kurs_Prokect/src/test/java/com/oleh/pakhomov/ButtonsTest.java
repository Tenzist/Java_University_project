package com.oleh.pakhomov;

import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeUnit;

public class ButtonsTest extends MathApplicationTest{

    @Test
    public void TestCalculationButton() {
        clickOn(Main.controller.endX);
        write("100.0");
        clickOn(Main.controller.calcButton);
        WaitForAsyncUtils.sleep(2, TimeUnit.SECONDS);
        Assertions.assertThat(Main.controller.result).isVisible();
    }
}
