package com.oleh.pakhomov;

import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeUnit;

public abstract class MathApplicationTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        new Main().start(stage);
        WaitForAsyncUtils.sleep(1, TimeUnit.SECONDS);
    }
}
