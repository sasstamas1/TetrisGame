import model.Form;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest {
    Rectangle a = new Rectangle();
    Rectangle b = new Rectangle();
    Rectangle c = new Rectangle();
    Rectangle d = new Rectangle();

    @Test
    void SzinTeszt1() {
        Form form = new Form(a, b, c, d, "j");
        assertEquals(Color.BLUE, form.color);
        Form form1 = new Form(a, b, c, d, "l");
        assertEquals(Color.GREEN, form1.color);
        Form form2 = new Form(a, b, c, d, "o");
        assertEquals(Color.GRAY, form2.color);
        Form form3 = new Form(a, b, c, d, "s");
        assertEquals(Color.DARKBLUE, form3.color);
        Form form4 = new Form(a, b, c, d, "t");
        assertEquals(Color.BROWN, form4.color);
        Form form5 = new Form(a, b, c, d, "z");
        assertEquals(Color.GOLD, form5.color);
        Form form6 = new Form(a, b, c, d, "i");
        assertEquals(Color.ORANGE, form6.color);
    }

    @Test
    void FormaTeszt() {
        Form form = new Form(a, b, c, d, "o");
        assertEquals(1, form.form);
        form.changeForm();
        assertEquals(2, form.form);
        form.changeForm();
        assertEquals(3, form.form);
        form.changeForm();
        assertEquals(4, form.form);
        form.changeForm();
        assertEquals(1, form.form);
    }

    @Test
    void Form() {
        Form form = new Form(a, b, c, d, "o");
        assertEquals(1, form.form);
    }
}
