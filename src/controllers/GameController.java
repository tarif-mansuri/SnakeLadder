package controllers;

import model.*;

import java.util.List;

public class GameController {

    public Game startGame(List<Player> players, List<Snake> snakes, List<Ladder> ladders){
        return Game.startGame(players, snakes, ladders);
    }
    public GameState makeMove(Game game){
        return game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

}
