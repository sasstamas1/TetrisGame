package Controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {
    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    Color color;
    private String name;
    public int form = 1;

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;

        switch (name) {
            case "j":
                color = Color.BLUE;
                break;
            case "l":
                color = Color.GREEN;
                break;
            case "o":
                color = Color.GRAY;
                break;
            case "s":
                color = Color.DARKBLUE;
                break;
            case "t":
                color = Color.BROWN;
                break;
            case "z":
                color = Color.GOLD;
                break;
            case "i":
                color = Color.ORANGE;
                break;

        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }



    public String getName() {
        return name;
    }


    public void changeForm() {
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }
}
