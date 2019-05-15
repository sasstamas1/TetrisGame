import controller.GameController;
import model.Form;
import model.Game;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    GameController gameController = new GameController();
    Game game = new Game();

    @Test
    void MakeRectTest1() {

        Form form = game.makeRect(1);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 - gameController.SIZE);
        b.setX(gameController.XMAX / 2 - gameController.SIZE);
        b.setY(gameController.SIZE);
        c.setX(gameController.XMAX / 2);
        c.setY(gameController.SIZE);
        d.setX(gameController.XMAX / 2 + gameController.SIZE);
        d.setY(gameController.SIZE);
        String name = "j";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));

    }

    @Test
    void MakeRectTest2() {

        Form form = game.makeRect(11);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 + gameController.SIZE);
        b.setX(gameController.XMAX / 2 - gameController.SIZE);
        b.setY(gameController.SIZE);
        c.setX(gameController.XMAX / 2);
        c.setY(gameController.SIZE);
        d.setX(gameController.XMAX / 2 + gameController.SIZE);
        d.setY(gameController.SIZE);
        String name = "l";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));

    }

    @Test
    void MakeRectTest3() {

        Form form = game.makeRect(21);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 - gameController.SIZE);
        b.setX(gameController.XMAX / 2);
        c.setX(gameController.XMAX / 2 - gameController.SIZE);
        c.setY(gameController.SIZE);
        d.setX(gameController.XMAX / 2);
        d.setY(gameController.SIZE);
        String name = "o";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));

    }


    @Test
    void MakeRectTest4() {

        Form form = game.makeRect(31);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 + gameController.SIZE);
        b.setX(gameController.XMAX / 2);
        c.setX(gameController.XMAX / 2);
        c.setY(gameController.SIZE);
        d.setX(gameController.XMAX / 2 - gameController.SIZE);
        d.setY(gameController.SIZE);
        String name = "s";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));

    }

    @Test
    void MakeRectTest5() {

        Form form = game.makeRect(41);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 - gameController.SIZE);
        b.setX(gameController.XMAX / 2);
        c.setX(gameController.XMAX / 2);
        c.setY(gameController.SIZE);
        d.setX(gameController.XMAX / 2 + gameController.SIZE);
        String name = "t";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));

    }

    @Test
    void MakeRectTest6() {

        Form form = game.makeRect(51);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 + gameController.SIZE);
        b.setX(gameController.XMAX / 2);
        c.setX(gameController.XMAX / 2 + gameController.SIZE);
        c.setY(gameController.SIZE);
        d.setX(gameController.XMAX / 2 + 2 * gameController.SIZE);
        d.setY(gameController.SIZE);
        String name = "z";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));
    }

    @Test
    void MakeRectTest7() {

        Form form = game.makeRect(61);

        Rectangle a = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                b = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                c = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1),
                d = new Rectangle(gameController.SIZE - 1, gameController.SIZE - 1);


        a.setX(gameController.XMAX / 2 - 2 * gameController.SIZE);
        b.setX(gameController.XMAX / 2 - gameController.SIZE);
        c.setX(gameController.XMAX / 2);
        d.setX(gameController.XMAX / 2 + gameController.SIZE);
        String name = "i";

        Form form1 = new Form(a, b, c, d, name);

        assertTrue(egyenlo(form, form1));

    }


    @Test
    void valamitest1() {
        Form form = game.makeRect(1);
        assertFalse(game.moveA(form));
        form.a.setY(23 * 25);

    }

    @Test
    void valamitest2() {
        Form form = game.makeRect(1);
        assertFalse(game.moveB(form));
    }

    @Test
    void valamitest3() {
        Form form = game.makeRect(1);
        assertFalse(game.moveC(form));
    }

    @Test
    void valamitest4() {
        Form form = game.makeRect(1);
        assertFalse(game.moveD(form));
    }


    @Test
    void MoveRightTest() {
        Form form = game.makeRect(1);
        if (form.a.getX() + gameController.MOVE <= gameController.XMAX - gameController.SIZE && form.b.getX() + gameController.MOVE <= GameController.XMAX - gameController.SIZE
                && form.c.getX() + gameController.MOVE <= GameController.XMAX - gameController.SIZE && form.d.getX() + gameController.MOVE <= GameController.XMAX - gameController.SIZE) {
            int movea = gameController.HALO[((int) form.a.getX() / gameController.SIZE) + 1][((int) form.a.getY() / gameController.SIZE)];
            int moveb = gameController.HALO[((int) form.b.getX() / gameController.SIZE) + 1][((int) form.b.getY() / gameController.SIZE)];
            int movec = gameController.HALO[((int) form.c.getX() / gameController.SIZE) + 1][((int) form.c.getY() / gameController.SIZE)];
            int moved = gameController.HALO[((int) form.d.getX() / gameController.SIZE) + 1][((int) form.d.getY() / gameController.SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() + gameController.MOVE);
                form.b.setX(form.b.getX() + gameController.MOVE);
                form.c.setX(form.c.getX() + gameController.MOVE);
                form.d.setX(form.d.getX() + gameController.MOVE);
            }

            Form form1 = game.makeRect(1);
            game.MoveRight(form1);

            assertTrue(egyenlo(form, form1));
        }

    }

    @Test
    void MoveLeftTest() {
        Form form = game.makeRect(1);
        if (form.a.getX() - gameController.MOVE >= 0 && form.b.getX() - gameController.MOVE >= 0 && form.c.getX() - gameController.MOVE >= 0
                && form.d.getX() - gameController.MOVE >= 0) {
            int movea = gameController.HALO[((int) form.a.getX() / gameController.SIZE) - 1][((int) form.a.getY() / gameController.SIZE)];
            int moveb = gameController.HALO[((int) form.b.getX() / gameController.SIZE) - 1][((int) form.b.getY() / gameController.SIZE)];
            int movec = gameController.HALO[((int) form.c.getX() / gameController.SIZE) - 1][((int) form.c.getY() / gameController.SIZE)];
            int moved = gameController.HALO[((int) form.d.getX() / gameController.SIZE) - 1][((int) form.d.getY() / gameController.SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() - gameController.MOVE);
                form.b.setX(form.b.getX() - gameController.MOVE);
                form.c.setX(form.c.getX() - gameController.MOVE);
                form.d.setX(form.d.getX() - gameController.MOVE);
            }
        }
        Form form1 = game.makeRect(1);
        game.MoveLeft(form1);

        assertTrue(egyenlo(form, form1));
    }


    @Test
    void MoveDownTest1() {
        Form form = game.makeRect(1);
        if (form.a.getY() + gameController.MOVE < gameController.YMAX && form.b.getY() + gameController.MOVE < gameController.YMAX && form.c.getY() + gameController.MOVE < gameController.YMAX
                && form.d.getY() + gameController.MOVE < gameController.YMAX) {
            int movea = gameController.HALO[(int) form.a.getX() / gameController.SIZE][((int) form.a.getY() / gameController.SIZE) + 1];
            int moveb = gameController.HALO[(int) form.b.getX() / gameController.SIZE][((int) form.b.getY() / gameController.SIZE) + 1];
            int movec = gameController.HALO[(int) form.c.getX() / gameController.SIZE][((int) form.c.getY() / gameController.SIZE) + 1];
            int moved = gameController.HALO[(int) form.d.getX() / gameController.SIZE][((int) form.d.getY() / gameController.SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + gameController.MOVE);
                form.b.setY(form.b.getY() + gameController.MOVE);
                form.c.setY(form.c.getY() + gameController.MOVE);
                form.d.setY(form.d.getY() + gameController.MOVE);
            }
        }
        Form form1 = game.makeRect(1);
        game.MoveDown(form1);

        assertTrue(egyenlo(form, form1));
    }

    @Test
    void MoveDownTest2() {
        Form form = game.makeRect(1);
        form.a.setY(25 * 23);
        form.b.setY(25 * 23);
        form.c.setY(25 * 23);
        form.d.setY(25 * 23);

        Form form1 = game.makeRect(1);
        form1.a.setY(25 * 23);
        form1.b.setY(25 * 23);
        form1.c.setY(25 * 23);
        form1.d.setY(25 * 23);

        game.MoveDown(form1);

        assertTrue(egyenlo(form, form1));
    }


    @Test
    boolean egyenlo(Form form, Form form1) {
        if (form.a.getX() == form1.a.getX() && form.a.getY() == form1.a.getY())
            if (form.b.getX() == form1.b.getX() && form.b.getY() == form1.b.getY())
                if (form.c.getX() == form1.c.getX() && form.c.getY() == form1.c.getY())
                    if (form.d.getX() == form1.d.getX() && form.d.getY() == form1.d.getY())
                        if (form.name == form1.name)
                            return true;


        return false;


    }
}