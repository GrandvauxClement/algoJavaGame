package model;

public class Player {

    String name;

    String symbole;

    public Player(String name, String symbole) {
        this.name = name;
        this.symbole = symbole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
