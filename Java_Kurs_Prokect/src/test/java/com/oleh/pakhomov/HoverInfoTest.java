package com.oleh.pakhomov;



import javafx.scene.Node;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;


public class HoverInfoTest extends MathApplicationTest {

    @Test
    public void shouldShowInfoOnHover() {
        moveTo("#infoStartX");

        var help = Main.controller.contextHelp;
        Assertions.assertThat(help).hasText("Начальная точка поиска");
        Assertions.assertThat(help).isVisible();
        shouldRemoveInfoOnHover();
    }

    @Test
    public void shouldRemoveInfoOnHover() {
        moveTo("#infoStartX");
        var help = Main.controller.contextHelp;
        Assertions.assertThat(help).hasText("Начальная точка поиска");
        Assertions.assertThat(help).isVisible();
        moveTo(Main.controller.graph);
        Condition<Node> cond = new Condition<>(
                node -> !node.isVisible(),
                "Is text NOT visible?"
        );
        Assertions.assertThat(help).is(cond);

    }
}
