import controllers.GameController;
import model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 0));
        players.add(new Player("Bob", 0));
        players.add(new Player("Charlie", 0));
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(30, 22));
        snakes.add(new Snake(80, 60));
        snakes.add(new Snake(72, 65));
        snakes.add(new Snake(50, 25));
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(10, 25));
        ladders.add(new Ladder(32, 44));
        ladders.add(new Ladder(81, 90));
        ladders.add(new Ladder(67, 87));
        GameController gameController = new GameController();
        Game game = gameController.startGame(players, snakes, ladders);
        while(gameController.getGameState(game)!= GameState.ENDED){
            gameController.makeMove(game);
        }
        System.out.println(gameController.getWinner(game).getName()+" won the game");
    }
}