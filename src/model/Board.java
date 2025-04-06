package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 100;
    private List<Cell> cells;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(List<Snake> snakes, List<Ladder> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.cells = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            cells.add(new Cell(i));
        }

        for(Snake snake : snakes) {
            cells.get(snake.getStart()).setSnake(snake);
        }

        for(Ladder ladder : ladders) {
            cells.get(ladder.getStart()).setLadder(ladder);
        }
    }
    public List<Cell> getCells() {
        return cells;
    }
}
