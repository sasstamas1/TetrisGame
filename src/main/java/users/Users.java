package users;

import javax.persistence.*;

/**
 * A felhasználó osztaly.
 */
@Entity
public class Users {

    /**
     * Felhasználó id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Felhasznaló név.
     */
    @Column(name = "Name")
    private String name;

    /**
     * Pontszám.
     */
    @Column(name = "Score")
    private int score;


    /**
     * A Users osztály konstruktora.
     *
     * @param name  felhasználó név.
     * @param score pontszám.
     */
    public Users(String name, int score) {
        this.name = name;
        this.score= score;
    }

    /**
     * @return a felhasználó nevét.
     */
    public String getName() {
        return name;
    }

    /**
     * A User nevének bekérése.
     * @param name a neve.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return a pontszám.
     */
    public int getScore() {
        return score;
    }

    /**
     * To String metódus a User osztályhoz.
     * @return a user adatai.
     */
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}