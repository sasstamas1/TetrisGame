package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Form {
    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    private String name;
    public int form = 1;

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }


    /**
     * Az adott 4 negyzet szinet allitja be az alakzat formajanak megfeleloen.
     *
     * @param a    alakzat 1. resze
     * @param b    alakzat 2. resze
     * @param c    alakzat 3. resze
     * @param d    alakzat 4. resze
     * @param name az alakzat neve
     */
    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        log.debug("Szin beallitas");
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


    /**
     * Az alakzat forgatasa soran, a formak valtoztatasa
     */
    public void changeForm() {
        log.debug("Froma valtas");
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }
}
