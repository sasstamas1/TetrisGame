package ModelTest;

import model.Form;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest {

    Rectangle a = new Rectangle();
    Rectangle b = new Rectangle();
    Rectangle c = new Rectangle();
    Rectangle d = new Rectangle();

    @Test
    void SzinTeszt1() {
        Form form = new Form(a, b, c, d, "j");
        assertEquals(Color.BLUE, form.getColor());
    }

    @Test
    void SzinTeszt2() {
        Form form = new Form(a, b, c, d, "l");
        assertEquals(Color.GREEN, form.getColor());
    }

    @Test
    void SzinTeszt3() {
        Form form = new Form(a, b, c, d, "o");
        assertEquals(Color.GRAY, form.getColor());
    }

    @Test
    void SzinTeszt4() {
        Form form = new Form(a, b, c, d, "s");
        assertEquals(Color.DARKBLUE, form.getColor());
    }

    @Test
    void SzinTeszt5() {
        Form form = new Form(a, b, c, d, "t");
        assertEquals(Color.BROWN, form.getColor());
    }

    @Test
    void SzinTeszt6() {
        Form form = new Form(a, b, c, d, "z");
        assertEquals(Color.GOLD, form.getColor());
    }

    @Test
    void SzinTeszt7() {
        Form form = new Form(a, b, c, d, "i");
        assertEquals(Color.ORANGE, form.getColor());
    }

    Form form = new Form(a, b, c, d, "j");

    @Test
    void FormaTeszt() {
        assertEquals(1, form.getForm());
    }

    @Test
    void FormaTeszt2() {
        form.changeForm();
        assertEquals(2, form.getForm());
    }

    @Test
    void FormaTeszt3() {
        form.changeForm();
        form.changeForm();
        assertEquals(3, form.getForm());
    }
}
