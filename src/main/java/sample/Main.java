package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {

    public static boolean game = false;

    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static String felhasznalo="";
    private static int top = 0;
    private static int linesNo;

    private static Form object;
    private static Form nextObj = Controller.makeRect();


    static {
        linesNo = 0;
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void jatek(){
        Stage uj = new Stage();
        game = true;

        for (int[] row : MESH) {
            Arrays.fill(row, 0);
        }

        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Pont: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        group.getChildren().addAll(scoretext, line);

        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);

        object = a;
        moveOnKeyPress(a);
        nextObj = Controller.makeRect();

        uj.setScene(scene);
        uj.setTitle("T E T R I S");
        uj.show();


        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
                                || object.d.getY() == 0)
                            top++;
                        else
                            top = 0;

                        if (top == 2) {
                            // GAME OVER
                            Text over = new Text("JÁTÉK VÉGE!");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 55 Italic;");
                            over.setY(YMAX/2);
                            over.setX(10);
                            group.getChildren().add(over);
                            game = false;
                        }
                        // Exit
                        if (top == 5) {
                            System.exit(0);
                        }

                        if (game) {
                            MoveDown(object);
                            scoretext.setText("Pont: " + Integer.toString(score));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);

    }


    private static void moveOnKeyPress(Form form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        Controller.MoveRight(form);
                        break;
                    case LEFT:
                        Controller.MoveLeft(form);
                        break;
                    case DOWN:
                        MoveDown(form);
                        break;
                    case UP:
                        Rotate(form);

                }
            }
        });
    }



    public static void MoveDown(Form form){
        if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
                && form.d.getY() + MOVE < YMAX) {
            int movea = MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
            int moveb = MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
            int movec = MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
            int moved = MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }
            score++;
        }
        if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
                || form.d.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            MESH[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            MESH[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            MESH[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            MESH[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            RemoveRows(group);

            Form a = nextObj;
            nextObj = Controller.makeRect();
            object = a;
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
            score++;
        }
    }


    private static void Rotate(Form form) {
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

    }

    private static void RemoveRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i + lines.size());
            full = 0;
        }

        if (lines.size() > 0)
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                score += 100;

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }
                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();

            }while(lines.size()>0);
    }



    private static boolean moveA(Form form) {
        return (MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveB(Form form) {
        return (MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveC(Form form) {
        return (MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveD(Form form) {
        return (MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
    }


    private static boolean forgat(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }


    private static void Jobbra(Rectangle rect){
        if (rect.getX() + MOVE <= XMAX-SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private static void Balra(Rectangle rect){
        if(rect.getX()-MOVE >= 0)
            rect.setX(rect.getX()-MOVE);

    }

    private static void Le(Rectangle rect){
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);
    }

    private static void Fel(Rectangle rect){
        if(rect.getY()-MOVE > 0)
            rect.setY(rect.getY()-MOVE);
    }


    public static void main(String[] args) {

        launch(args);

    }

}