package model;

public class Cell {
    private int position;
    private Snake snake;
    private Ladder ladder;
    public Cell(int position) {
        this.position = position;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
