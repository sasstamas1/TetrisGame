package ModelTest;

import model.Form;
import model.Game;
import model.Rotate;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateTest {
    Rectangle rectangle = new Rectangle();
    Rotate rotate = new Rotate();

    @Test
    void ForgatTest() {
        assertEquals(false, rotate.forgat(rectangle, -2, -2));
        assertEquals(false, rotate.forgat(rectangle, 1, 1));
        assertEquals(false, rotate.forgat(rectangle, -2, 2));
    }

    @Test
    void ForgatTest2() {
        assertEquals(true, rotate.forgat(rectangle, 2, -2));
    }

    @Test
    void JobbraTest() {
        double kezdet = rectangle.getX();
        rotate.Jobbra(rectangle);
        assertEquals(kezdet + 25, rectangle.getX());
    }

    @Test
    void BalraTest() {
        double kezdet = rectangle.getX();
        rotate.Balra(rectangle);
        assertEquals(kezdet, rectangle.getX());
    }

    @Test
    void LeTest() {
        double kezdet = rectangle.getY();
        rotate.Le(rectangle);
        assertEquals(kezdet + 25, rectangle.getY());
    }

    @Test
    void FelTest() {
        double kezdet = rectangle.getY();
        rotate.Fel(rectangle);
        assertEquals(kezdet, rectangle.getY());
    }

    Game game = new Game();
    Rectangle a = new Rectangle();
    Rectangle b = new Rectangle();
    Rectangle c = new Rectangle();
    Rectangle d = new Rectangle();
    Form form = game.makeRect(2);

    @Test
    void ForgatTeszt() {
        rotate.Rotate(form);
        assertEquals(2, form.getForm());

    }


}
