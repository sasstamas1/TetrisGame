package model;


import controller.GameController;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;


@Slf4j
public class Game {

    static GameController gameController = new GameController();

    /**
     * Letrehozza a random alakzatot, 4 kulonallo negyzet segetsegevel.
     *
     * @return Az elkeszitett alakzatot adja vissza, a Form osztaly segetsegevel
     */
    public static Form makeRect(int block) {

        String name;

        Rectangle a = new Rectangle(gameController.SIZE-1,gameController.SIZE-1),
                b = new Rectangle(gameController.SIZE-1,gameController.SIZE-1),
                c = new Rectangle(gameController.SIZE-1,gameController.SIZE-1),
                d = new Rectangle(gameController.SIZE-1,gameController.SIZE-1);


        if (block < 10) {
            a.setX(gameController.XMAX / 2 - gameController.SIZE);
            b.setX(gameController.XMAX / 2 - gameController.SIZE);
            b.setY(gameController.SIZE);
            c.setX(gameController.XMAX / 2);
            c.setY(gameController.SIZE);
            d.setX(gameController.XMAX / 2 + gameController.SIZE);
            d.setY(gameController.SIZE);
            name = "j";
        } else if (block < 20) {
            a.setX(gameController.XMAX / 2 + gameController.SIZE);
            b.setX(gameController.XMAX / 2 - gameController.SIZE);
            b.setY(gameController.SIZE);
            c.setX(gameController.XMAX / 2);
            c.setY(gameController.SIZE);
            d.setX(gameController.XMAX / 2 + gameController.SIZE);
            d.setY(gameController.SIZE);
            name = "l";
        } else if (block < 30) {
            a.setX(gameController.XMAX / 2 - gameController.SIZE);
            b.setX(gameController.XMAX / 2);
            c.setX(gameController.XMAX / 2 - gameController.SIZE);
            c.setY(gameController.SIZE);
            d.setX(gameController.XMAX / 2);
            d.setY(gameController.SIZE);
            name = "o";
        } else if (block < 40) {
            a.setX(gameController.XMAX / 2 + gameController.SIZE);
            b.setX(gameController.XMAX / 2);
            c.setX(gameController.XMAX / 2);
            c.setY(gameController.SIZE);
            d.setX(gameController.XMAX / 2 - gameController.SIZE);
            d.setY(gameController.SIZE);
            name = "s";
        } else if (block < 50) {
            a.setX(gameController.XMAX / 2 - gameController.SIZE);
            b.setX(gameController.XMAX / 2);
            c.setX(gameController.XMAX / 2);
            c.setY(gameController.SIZE);
            d.setX(gameController.XMAX / 2 + gameController.SIZE);
            name = "t";
        } else if (block < 60) {
            a.setX(gameController.XMAX / 2 + gameController.SIZE);
            b.setX(gameController.XMAX / 2);
            c.setX(gameController.XMAX / 2 + gameController.SIZE);
            c.setY(gameController.SIZE);
            d.setX(gameController.XMAX / 2 + 2 * gameController.SIZE);
            d.setY(gameController.SIZE);
            name = "z";
        } else {
            a.setX(gameController.XMAX / 2 - 2 * gameController.SIZE);
            b.setX(gameController.XMAX / 2 - gameController.SIZE);
            c.setX(gameController.XMAX / 2);
            d.setX(gameController.XMAX / 2 + gameController.SIZE);
            name = "i";
        }
        return new Form(a, b, c, d, name);

    }

    /**
     * Az alakzatok jobbra mozgatasa.
     *
     * @param form - az alakzat.
     */
    public static void MoveRight(Form form) {
        if (form.a.getX() + gameController.MOVE <=gameController.XMAX - gameController.SIZE && form.b.getX() + gameController.MOVE <= GameController.XMAX - gameController.SIZE
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

                log.debug("Jobbra mozgas");
            }
        }
    }

    /**
     * Az alakzatok balraa mozgatasa.
     *
     * @param form - az alakzat.
     */
    public static void MoveLeft(Form form) {
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
                log.debug("Balrara mozgas");
            }
        }
    }

    /**
     * Az alakzatok folyamatos lefele mozgasa es gyorsitasa.
     *
     * @param form - az alakzat.
     */
    public static void MoveDown(Form form){

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
            log.debug("Lefele mozgas");
            gameController.setPont(gameController.getPont()+1);
        }
        if (form.a.getY() == gameController.YMAX - gameController.SIZE || form.b.getY() == gameController.YMAX - gameController.SIZE || form.c.getY() == gameController.YMAX - gameController.SIZE
                || form.d.getY() == gameController.YMAX - gameController.SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            gameController.HALO[(int) form.a.getX() / gameController.SIZE][(int) form.a.getY() / gameController.SIZE] = 1;
            gameController.HALO[(int) form.b.getX() / gameController.SIZE][(int) form.b.getY() / gameController.SIZE] = 1;
            gameController.HALO[(int) form.c.getX() / gameController.SIZE][(int) form.c.getY() / gameController.SIZE] = 1;
            gameController.HALO[(int) form.d.getX() / gameController.SIZE][(int) form.d.getY() / gameController.SIZE] = 1;
            DeleteRows(gameController.group);

            Form a = gameController.nextObj;
            gameController.nextObj = makeRect(gameController.makeRandom());
            gameController.object = a;
            gameController.group.getChildren().addAll(a.a, a.b, a.c, a.d);
            gameController.moveOnKeyPress(a);
            gameController.setPont(gameController.getPont()+1);


            log.debug("Gyorsabb mozgas lefela");
        }
    }

    /**
     * A sorok kitorlese.
     * @param pane - az a Pane, amelyen a jatek folyik.
     */
    public static void DeleteRows(Pane pane){
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;

        //Megkeress�k azokat a sorokat, amelyek tele vannak.
        for(int i = 0; i < gameController.HALO[0].length; i++){
            for(int j = 0; j < gameController.HALO.length; j++){
                if(gameController.HALO[j][i] == 1)
                    full++;
            }
            if(full == gameController.HALO.length)
                lines.add(i+lines.size());
            full = 0;
        }


        //Kit�r�lj�k azokat a sorokat, amelyek tele vannak.
        if(lines.size() > 0)
            do{
                for(Node node: pane.getChildren()) {
                    if(node instanceof Rectangle)
                        rects.add(node);
                }
                gameController.pont += 100;


                //Kit�r�lj�k a blokkokat a tele sorokb�l
                for(Node node: rects){
                    Rectangle a = (Rectangle)node;
                    if(a.getY() == lines.get(0)*gameController.SIZE){
                        try {
                            gameController.HALO[(int)a.getX()/gameController.SIZE][(int)a.getY()/gameController.SIZE] = 0;
                            pane.getChildren().remove(node);
                        }catch (ArrayIndexOutOfBoundsException e){
                        }


                    } else
                        newrects.add(node);
                }


                //Az iter�ci�n bel�l probl�m�s volt.
                for(Node node: newrects){
                    Rectangle a = (Rectangle)node;
                    if(a.getY() < lines.get(0)*gameController.SIZE){
                        gameController.HALO[(int)a.getX()/gameController.SIZE][(int)a.getY()/gameController.SIZE] = 0;
                        a.setY(a.getY() + gameController.SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                for(Node node: pane.getChildren()) {
                    if(node instanceof Rectangle)
                        rects.add(node);
                }
                for(Node node: rects){
                    Rectangle a = (Rectangle)node;
                    try {
                        gameController.HALO[(int)a.getX()/gameController.SIZE][(int)a.getY()/gameController.SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();

                log.info("Sor torles");
            } while (lines.size() > 0);
    }

    /**
     * Mozoghat e lefele az alakzatunk A resze.
     *
     * @param form - az alakzat.
     * @return - False ha nem mozoghat, true ha mozoghat.
     */
    public static boolean moveA(Form form) {
        return (gameController.HALO[(int) form.a.getX() / gameController.SIZE][((int) form.a.getY() / gameController.SIZE) + 1] == 1);
    }

    /**
     * Mozoghat e lefele az alakzatunk B resze.
     *
     * @param form - az alakzat.
     * @return - False ha nem mozoghat, true ha mozoghat.
     */
    public static boolean moveB(Form form) {
        return (gameController.HALO[(int) form.b.getX() / gameController.SIZE][((int) form.b.getY() / gameController.SIZE) + 1] == 1);
    }

    /**
     * Mozoghat e lefele az alakzatunk C resze.
     *
     * @param form - az alakzat.
     * @return - False ha nem mozoghat, true ha mozoghat.
     */
    public static boolean moveC(Form form) {
        return (gameController.HALO[(int) form.c.getX() / gameController.SIZE][((int) form.c.getY() / gameController.SIZE) + 1] == 1);
    }

    /**
     * Mozoghat e lefele az alakzatunk D resze.
     * @param form - az alakzat.
     * @return - False ha nem mozoghat, true ha mozoghat.
     */
    public static boolean moveD(Form form) {
        return (gameController.HALO[(int) form.d.getX() / gameController.SIZE][((int) form.d.getY() / gameController.SIZE) + 1] == 1);
    }
}
