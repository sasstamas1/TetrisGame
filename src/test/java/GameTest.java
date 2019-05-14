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
    void valamitest() {
        Form form = game.makeRect(1);
        assertFalse(game.moveA(form));
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