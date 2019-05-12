package Model;

;
import Controller.GameController;
import javafx.scene.shape.Rectangle;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Rotate {

    static GameController gameController = new GameController();

    public static void Rotate(From form) {
        int f = form.form;
        Rectangle a = form.a;
        Rectangle b = form.b;
        Rectangle c = form.c;
        Rectangle d = form.d;
        switch (form.getName()){
            case "j":
                if (f == 1 && forgat(a, 1, -1) && forgat(c, -1, -1) && forgat(d, -2, -2)) {
                    Jobbra(form.a);
                    Le(form.a);
                    Le(form.c);
                    Balra(form.c);
                    Le(form.d);
                    Le(form.d);
                    Balra(form.d);
                    Balra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && forgat(a, -1, -1) && forgat(c, -1, 1) && forgat(d, -2, 2)) {
                    Le(form.a);
                    Balra(form.a);
                    Balra(form.c);
                    Fel(form.c);
                    Balra(form.d);
                    Balra(form.d);
                    Fel(form.d);
                    Fel(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && forgat(a, -1, 1) && forgat(c, 1, 1) && forgat(d, 2, 2)) {
                    Balra(form.a);
                    Fel(form.a);
                    Fel(form.c);
                    Jobbra(form.c);
                    Fel(form.d);
                    Fel(form.d);
                    Jobbra(form.d);
                    Jobbra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && forgat(a, 1, 1) && forgat(c, 1, -1) && forgat(d, 2, -2)) {
                    Fel(form.a);
                    Jobbra(form.a);
                    Jobbra(form.c);
                    Le(form.c);
                    Jobbra(form.d);
                    Jobbra(form.d);
                    Le(form.d);
                    Le(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && forgat(a, 1, -1) && forgat(c, 1, 1) && forgat(b, 2, 2)) {
                    Jobbra(form.a);
                    Le(form.a);
                    Fel(form.c);
                    Jobbra(form.c);
                    Fel(form.b);
                    Fel(form.b);
                    Jobbra(form.b);
                    Jobbra(form.b);
                    form.changeForm();
                    break;
                }
                if (f == 2 && forgat(a, -1, -1) && forgat(b, 2, -2) && forgat(c, 1, -1)) {
                    Le(form.a);
                    Balra(form.a);
                    Jobbra(form.b);
                    Jobbra(form.b);
                    Le(form.b);
                    Le(form.b);
                    Jobbra(form.c);
                    Le(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 3 && forgat(a, -1, 1) && forgat(c, -1, -1) && forgat(b, -2, -2)) {
                    Balra(form.a);
                    Fel(form.a);
                    Le(form.c);
                    Balra(form.c);
                    Le(form.b);
                    Le(form.b);
                    Balra(form.b);
                    Balra(form.b);
                    form.changeForm();
                    break;
                }
                if (f == 4 && forgat(a, 1, 1) && forgat(b, -2, 2) && forgat(c, -1, 1)) {
                    Fel(form.a);
                    Jobbra(form.a);
                    Balra(form.b);
                    Balra(form.b);
                    Fel(form.b);
                    Fel(form.b);
                    Balra(form.c);
                    Fel(form.c);
                    form.changeForm();
                    break;
                }
                break;
            case "s":
                if (f == 1 && forgat(a, -1, -1) && forgat(c, -1, 1) && forgat(d, 0, 2)) {
                    Le(form.a);
                    Balra(form.a);
                    Balra(form.c);
                    Fel(form.c);
                    Fel(form.d);
                    Fel(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && forgat(a, 1, 1) && forgat(c, 1, -1) && forgat(d, 0, -2)) {
                    Fel(form.a);
                    Jobbra(form.a);
                    Jobbra(form.c);
                    Le(form.c);
                    Le(form.d);
                    Le(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && forgat(a, -1, -1) && forgat(c, -1, 1) && forgat(d, 0, 2)) {
                    Le(form.a);
                    Balra(form.a);
                    Balra(form.c);
                    Fel(form.c);
                    Fel(form.d);
                    Fel(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && forgat(a, 1, 1) && forgat(c, 1, -1) && forgat(d, 0, -2)) {
                    Fel(form.a);
                    Jobbra(form.a);
                    Jobbra(form.c);
                    Le(form.c);
                    Le(form.d);
                    Le(form.d);
                    form.changeForm();
                    break;
                }
            case "t":
                if (f == 1 && forgat(a, 1, 1) && forgat(d, -1, -1) && forgat(c, -1, 1)) {
                    Fel(form.a);
                    Jobbra(form.a);
                    Le(form.d);
                    Balra(form.d);
                    Balra(form.c);
                    Fel(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 2 && forgat(a, 1, -1) && forgat(d, -1, 1) && forgat(c, 1, 1)) {
                    Jobbra(form.a);
                    Le(form.a);
                    Balra(form.d);
                    Fel(form.d);
                    Fel(form.c);
                    Jobbra(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 3 && forgat(a, -1, -1) && forgat(d, 1, 1) && forgat(c, 1, -1)) {
                    Le(form.a);
                    Balra(form.a);
                    Fel(form.d);
                    Jobbra(form.d);
                    Jobbra(form.c);
                    Le(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 4 && forgat(a, -1, 1) && forgat(d, 1, -1) && forgat(c, -1, -1)) {
                    Balra(form.a);
                    Fel(form.a);
                    Jobbra(form.d);
                    Le(form.d);
                    Le(form.c);
                    Balra(form.c);
                    form.changeForm();
                    break;
                }
            case "z":
                if (f == 1 && forgat(b, 1, 1) && forgat(c, -1, 1) && forgat(d, -2, 0)) {
                    Fel(form.b);
                    Jobbra(form.b);
                    Balra(form.c);
                    Fel(form.c);
                    Balra(form.d);
                    Balra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && forgat(b, -1, -1) && forgat(c, 1, -1) && forgat(d, 2, 0)) {
                    Le(form.b);
                    Balra(form.b);
                    Jobbra(form.c);
                    Le(form.c);
                    Jobbra(form.d);
                    Jobbra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && forgat(b, 1, 1) && forgat(c, -1, 1) && forgat(d, -2, 0)) {
                    Fel(form.b);
                    Jobbra(form.b);
                    Balra(form.c);
                    Fel(form.c);
                    Balra(form.d);
                    Balra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && forgat(b, -1, -1) && forgat(c, 1, -1) && forgat(d, 2, 0)) {
                    Le(form.b);
                    Balra(form.b);
                    Jobbra(form.c);
                    Le(form.c);
                    Jobbra(form.d);
                    Jobbra(form.d);
                    form.changeForm();
                    break;
                }
            case "i":
                if (f == 1 && forgat(a, 2, 2) && forgat(b, 1, 1) && forgat(d, -1, -1)) {
                    Fel(form.a);
                    Fel(form.a);
                    Jobbra(form.a);
                    Jobbra(form.a);
                    Fel(form.b);
                    Jobbra(form.b);
                    Le(form.d);
                    Balra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && forgat(a, -2, -2) && forgat(b, -1, -1) && forgat(d, 1, 1)) {
                    Le(form.a);
                    Le(form.a);
                    Balra(form.a);
                    Balra(form.a);
                    Le(form.b);
                    Balra(form.b);
                    Fel(form.d);
                    Jobbra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && forgat(a, 2, 2) && forgat(b, 1, 1) && forgat(d, -1, -1)) {
                    Fel(form.a);
                    Fel(form.a);
                    Jobbra(form.a);
                    Jobbra(form.a);
                    Fel(form.b);
                    Jobbra(form.b);
                    Le(form.d);
                    Balra(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && forgat(a, -2, -2) && forgat(b, -1, -1) && forgat(d, 1, 1)) {
                    Le(form.a);
                    Le(form.a);
                    Balra(form.a);
                    Balra(form.a);
                    Le(form.b);
                    Balra(form.b);
                    Fel(form.d);
                    Jobbra(form.d);
                    form.changeForm();
                    break;
                }

        }

        log.debug("Alakzat forgatása");
    }


    private static boolean forgat(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * gameController.MOVE <= gameController.XMAX - gameController.SIZE;
        if (x < 0)
            xb = rect.getX() + x * gameController.MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * gameController.MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * gameController.MOVE < gameController.YMAX;
        return xb && yb && gameController.HALO[((int) rect.getX() / gameController.SIZE) + x][((int) rect.getY() / gameController.SIZE) - y] == 0;
    }


    private static void Jobbra(Rectangle rect){
        if (rect.getX() + gameController.MOVE <= gameController.XMAX-gameController.SIZE)
            rect.setX(rect.getX() + gameController.MOVE);
    }

    private static void Balra(Rectangle rect){
        if(rect.getX()-gameController.MOVE >= 0)
            rect.setX(rect.getX()-gameController.MOVE);

    }

    private static void Le(Rectangle rect){
        if (rect.getY() + gameController.MOVE < gameController.YMAX)
            rect.setY(rect.getY() + gameController.MOVE);
    }

    private static void Fel(Rectangle rect){
        if(rect.getY()-gameController.MOVE > 0)
            rect.setY(rect.getY()-gameController.MOVE);
    }
}
