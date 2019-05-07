package sample;

public class Moves {

    public static final int MOVE = Main.MOVE;
    public static final int SIZE = Main.SIZE;
    public static int XMAX = Main.XMAX;
    public static int YMAX = Main.YMAX;
    public static int[][] HALO = Main.HALO;

    public static void MoveRight(Form form) {
        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
                && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {
            int movea = HALO[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveb = HALO[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
            int movec = HALO[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
            int moved = HALO[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);
            }
        }
    }

    public static void MoveLeft(Form form) {
        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
                && form.d.getX() - MOVE >= 0) {
            int movea = HALO[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveb = HALO[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
            int movec = HALO[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
            int moved = HALO[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            }
        }
    }


}
