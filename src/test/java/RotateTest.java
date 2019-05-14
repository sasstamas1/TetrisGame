import javafx.scene.shape.Rectangle;
import model.Form;
import model.Rotate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotateTest {


    Rectangle a = new Rectangle();
    Rectangle b = new Rectangle();
    Rectangle c = new Rectangle();
    Rectangle d = new Rectangle();

    @Test
    void RotateTest1() {
        Form form = new Form(a, b, c, d, "j");
        Form form1 = new Form(a, b, c, d, "j");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, -1, -1) && rotate.forgat(d, -2, -2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.d);
            rotate.Le(form.d);
            rotate.Balra(form.d);
            rotate.Balra(form.d);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(c, -1, 1) && rotate.forgat(d, -2, 2)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Balra(form.c);
            rotate.Fel(form.c);
            rotate.Balra(form.d);
            rotate.Balra(form.d);
            rotate.Fel(form.d);
            rotate.Fel(form.d);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, 1, 1) && rotate.forgat(d, 2, 2)) {
            rotate.Balra(form.a);
            rotate.Fel(form.a);
            rotate.Fel(form.c);
            rotate.Jobbra(form.c);
            rotate.Fel(form.d);
            rotate.Fel(form.d);
            rotate.Jobbra(form.d);
            rotate.Jobbra(form.d);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(c, 1, -1) && rotate.forgat(d, 2, -2)) {
            rotate.Fel(form.a);
            rotate.Jobbra(form.a);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            rotate.Jobbra(form.d);
            rotate.Jobbra(form.d);
            rotate.Le(form.d);
            rotate.Le(form.d);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }


    @Test
    void RotateTest2() {
        Form form = new Form(a, b, c, d, "l");
        Form form1 = new Form(a, b, c, d, "l");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, 1, 1) && rotate.forgat(b, 2, 2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Fel(form.c);
            rotate.Jobbra(form.c);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(b, 2, -2) && rotate.forgat(c, 1, -1)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, -1, -1) && rotate.forgat(b, -2, -2)) {
            rotate.Balra(form.a);
            rotate.Fel(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(b, -2, 2) && rotate.forgat(c, -1, 1)) {
            rotate.Fel(form.a);
            rotate.Jobbra(form.a);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Balra(form.c);
            rotate.Fel(form.c);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }

    @Test
    void RotateTest3() {
        Form form = new Form(a, b, c, d, "o");
        Form form1 = new Form(a, b, c, d, "o");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, 1, 1) && rotate.forgat(b, 2, 2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Fel(form.c);
            rotate.Jobbra(form.c);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(b, 2, -2) && rotate.forgat(c, 1, -1)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, -1, -1) && rotate.forgat(b, -2, -2)) {
            rotate.Balra(form.a);
            rotate.Fel(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(b, -2, 2) && rotate.forgat(c, -1, 1)) {
            rotate.Fel(form.a);
            rotate.Jobbra(form.a);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Balra(form.c);
            rotate.Fel(form.c);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }

    @Test
    void RotateTest4() {
        Form form = new Form(a, b, c, d, "s");
        Form form1 = new Form(a, b, c, d, "s");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, 1, 1) && rotate.forgat(b, 2, 2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Le(form.c);
            rotate.Jobbra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(b, 2, -2) && rotate.forgat(c, 1, -1)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, -1, -1) && rotate.forgat(b, -2, -2)) {
            rotate.Balra(form.a);
            rotate.Le(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(b, -2, 2) && rotate.forgat(c, -1, 1)) {
            rotate.Le(form.a);
            rotate.Jobbra(form.a);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }

    @Test
    void RotateTest5() {
        Form form = new Form(a, b, c, d, "t");
        Form form1 = new Form(a, b, c, d, "t");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, 1, 1) && rotate.forgat(b, 2, 2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Fel(form.c);
            rotate.Jobbra(form.c);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(b, 2, -2) && rotate.forgat(c, 1, -1)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, -1, -1) && rotate.forgat(b, -2, -2)) {
            rotate.Balra(form.a);
            rotate.Fel(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(b, -2, 2) && rotate.forgat(c, -1, 1)) {
            rotate.Fel(form.a);
            rotate.Jobbra(form.a);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Balra(form.c);
            rotate.Fel(form.c);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }

    @Test
    void RotateTest6() {
        Form form = new Form(a, b, c, d, "z");
        Form form1 = new Form(a, b, c, d, "z");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, 1, 1) && rotate.forgat(b, 2, 2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Fel(form.c);
            rotate.Jobbra(form.c);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(b, 2, -2) && rotate.forgat(c, 1, -1)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, -1, -1) && rotate.forgat(b, -2, -2)) {
            rotate.Balra(form.a);
            rotate.Fel(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(b, -2, 2) && rotate.forgat(c, -1, 1)) {
            rotate.Fel(form.a);
            rotate.Jobbra(form.a);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Balra(form.c);
            rotate.Fel(form.c);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }

    @Test
    void RotateTest7() {
        Form form = new Form(a, b, c, d, "i");
        Form form1 = new Form(a, b, c, d, "i");
        Rotate rotate = new Rotate();

        rotate.Rotate(form);

        if (form.form == 1 && rotate.forgat(a, 1, -1) && rotate.forgat(c, 1, 1) && rotate.forgat(b, 2, 2)) {
            rotate.Jobbra(form.a);
            rotate.Le(form.a);
            rotate.Fel(form.c);
            rotate.Jobbra(form.c);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            form.changeForm();
        }
        if (form.form == 2 && rotate.forgat(a, -1, -1) && rotate.forgat(b, 2, -2) && rotate.forgat(c, 1, -1)) {
            rotate.Le(form.a);
            rotate.Balra(form.a);
            rotate.Jobbra(form.b);
            rotate.Jobbra(form.b);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Jobbra(form.c);
            rotate.Le(form.c);
            form.changeForm();
        }
        if (form.form == 3 && rotate.forgat(a, -1, 1) && rotate.forgat(c, -1, -1) && rotate.forgat(b, -2, -2)) {
            rotate.Balra(form.a);
            rotate.Fel(form.a);
            rotate.Le(form.c);
            rotate.Balra(form.c);
            rotate.Le(form.b);
            rotate.Le(form.b);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            form.changeForm();
        }
        if (form.form == 4 && rotate.forgat(a, 1, 1) && rotate.forgat(b, -2, 2) && rotate.forgat(c, -1, 1)) {
            rotate.Fel(form.a);
            rotate.Jobbra(form.a);
            rotate.Balra(form.b);
            rotate.Balra(form.b);
            rotate.Fel(form.b);
            rotate.Fel(form.b);
            rotate.Balra(form.c);
            rotate.Fel(form.c);
            form.changeForm();
        }
        assertTrue(egyenlo(form, form1));
    }


    @Test
    void ForgatTest() {
        Rotate rotate = new Rotate();
        assertFalse(rotate.forgat(a, 1, 1));
    }


    @Test
    void JobbraTest() {
        double kezdet = a.getX();
        Rotate rotate = new Rotate();
        rotate.Jobbra(a);
        assertEquals(kezdet + 25, a.getX());
    }

    @Test
    void BalraTest() {
        double kezdet = a.getX();
        Rotate rotate = new Rotate();
        rotate.Balra(a);
        assertEquals(kezdet, a.getX());
    }

    @Test
    void LeTest() {
        double kezdet = a.getY();
        Rotate rotate = new Rotate();
        rotate.Le(a);
        assertEquals(kezdet + 25, a.getY());
    }

    @Test
    void FelTest() {
        double kezdet = a.getY();
        Rotate rotate = new Rotate();
        rotate.Fel(a);
        assertEquals(kezdet, a.getY());
    }


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
