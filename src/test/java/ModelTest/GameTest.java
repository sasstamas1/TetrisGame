package ModelTest;

import Model.Form;
import Model.Game;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    Game game = new Game();
    Form form = game.makeRect();

    @Test
    void MoveRightTest() {
        double kezdeti = form.a.getX();
        game.MoveRight(form);
        assertEquals(kezdeti + 25, form.a.getX());
    }

    @Test
    void MoveLeftTest() {
        double kezdeti = form.a.getX();
        game.MoveLeft(form);
        assertEquals(kezdeti - 25, form.a.getX());
    }

    @Test
    void MoveDownTest() {
        double kezdeti = form.a.getY();
        game.MoveDown(form);
        assertEquals(kezdeti + 25, form.a.getY());
    }

    @Test
    void moveATest() {
        assertEquals(false, game.moveA(form));
    }

    @Test
    void moveBTest() {
        assertEquals(false, game.moveB(form));
    }


    @Test
    void moveCTest() {
        assertEquals(false, game.moveC(form));
    }


    @Test
    void moveDTest() {
        assertEquals(false, game.moveD(form));
    }


}
