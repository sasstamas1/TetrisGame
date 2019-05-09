package Model;

import Controller.GameController;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static Controller.GameController.*;

public class Game {

    public static From makeRect(){
        int block = (int) (Math.random() * 70);
        // int block = 11;
        String name;

        Rectangle a = new Rectangle(SIZE-1,SIZE-1),
                b = new Rectangle(SIZE-1,SIZE-1),
                c = new Rectangle(SIZE-1,SIZE-1),
                d = new Rectangle(SIZE-1,SIZE-1);


        if (block < 10) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 20) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 30) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 40) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 50) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + 2 * SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - 2 * SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }
        return new From(a, b, c, d, name);

    }

    public static void MoveRight(From form) {
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

    public static void MoveLeft(From form) {
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

    public static void MoveDown(From form){
        if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
                && form.d.getY() + MOVE < YMAX) {
            int movea = HALO[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
            int moveb = HALO[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
            int movec = HALO[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
            int moved = HALO[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }

            Game.DeleteRows(GameController.group);
            GameController.pont++;
        }
        if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
                || form.d.getY() == YMAX - SIZE || Game.moveA(form) || Game.moveB(form) || Game.moveC(form) || Game.moveD(form)) {
            HALO[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            HALO[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            HALO[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            HALO[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            Game.DeleteRows(GameController.group);

            From a = GameController.nextObj;
            GameController.nextObj = makeRect();
            GameController.object = a;
            GameController.group.getChildren().addAll(a.a, a.b, a.c, a.d);
            GameController.moveOnKeyPress(a);
            GameController.pont++;
        }
    }

    public static void DeleteRows(Pane pane){
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        //Finding which line is full
        for(int i = 0; i < HALO[0].length; i++){
            for(int j = 0; j < HALO.length; j++){
                if(HALO[j][i] == 1)
                    full++;
            }
            if(full == HALO.length)
                lines.add(i+lines.size());
            full = 0;
        }
        //Deleting rows if any is full
        if(lines.size() > 0)
            do{
                for(Node node: pane.getChildren()) {
                    if(node instanceof Rectangle)
                        rects.add(node);
                }
                GameController.pont += 100;
                //Deleting the blocks on the full row
                for(Node node: rects){
                    Rectangle a = (Rectangle)node;
                    if(a.getY() == lines.get(0)*SIZE){
                        try {
                            HALO[(int)a.getX()/SIZE][(int)a.getY()/SIZE] = 0;
                            pane.getChildren().remove(node);
                        } catch (ArrayIndexOutOfBoundsException e){
                        }

                    }
                    else
                        newrects.add(node);
                }
                //Added because it was causing problems when it was inside the iteration above.
                for(Node node: newrects){
                    Rectangle a = (Rectangle)node;
                    if(a.getY() < lines.get(0)*SIZE){
                        try {
                            HALO[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                            a.setY(a.getY() + SIZE);
                        }catch (ArrayIndexOutOfBoundsException e){

                        }
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
                        HALO[(int)a.getX()/SIZE][(int)a.getY()/SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();
            } while(lines.size() > 0);
    }

    public static boolean moveA(From form) {
        return (HALO[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
    }

    public static boolean moveB(From form) {
        return (HALO[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
    }

    public static boolean moveC(From form) {
        return (HALO[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
    }

    public static boolean moveD(From form) {
        return (HALO[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
    }
}
