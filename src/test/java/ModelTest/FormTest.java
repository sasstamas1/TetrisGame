package ModelTest;

import Model.Form;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest {

    Rectangle a = new Rectangle();
    Rectangle b = new Rectangle();
    Rectangle c = new Rectangle();
    Rectangle d = new Rectangle();
    Form form = new Form(a, b, c, d, "j");

    @Test
    void SzinTeszt() {
        assertEquals(Color.BLUE, form.getColor());
    }

    @Test
    void FormaTeszt() {
        assertEquals(1, form.getForm());
    }
}
