package model;

public class Player {
    private String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public int makeMove(Dice dice) {
        int value = dice.roll();
        System.out.println(this.name + " rolls " + value);
        return value;
    }
}
