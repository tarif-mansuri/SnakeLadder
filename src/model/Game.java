package model;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;
    private int currentPlayerIndex;
    private Player winner;
    private GameState gameState;

    private Game(Builder builder) {
        this.board = builder.board;
        this.players = builder.players;
        this.dice = builder.dice;
        this.currentPlayerIndex = 0;
        this.gameState = GameState.INPROGRESS;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private Dice dice;
        private GameState gameState;

        public Builder setBoard(Board board){
            this.board = board;
            return this;
        }
        public Builder setPlayers(List<Player> players){
            if(players == null || players.size() <2 || players.size() > 4){
                throw new IllegalArgumentException("players list must contain at least 2 or less than equal to 4");
            }
            this.players = players;
            return this;
        }
        public Builder setDice(Dice dice){
            this.dice = dice;
            return this;
        }
        public Builder setGameState(GameState gameState){
            this.gameState = gameState;
            return this;
        }

        public Game build(){
            return new Game(this);
        }

    }

    public static Game startGame(List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
        Board board = new Board(snakes, ladders);
        Dice dice = new Dice();
        return Game.getBuilder().setPlayers(players).setBoard(board).setDice(dice).setGameState(GameState.INPROGRESS).build();
    }

    public GameState makeMove(){
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        int value = currentPlayer.makeMove(this.dice);
        if(currentPlayer.getPosition()+value < 99){
            currentPlayer.setPosition(currentPlayer.getPosition()+value);
            System.out.println(currentPlayer.getName()+"'s current position is : "+ currentPlayer.getPosition());
            Cell currentCell = board.getCells().get(currentPlayer.getPosition());
            if(currentCell.getLadder() != null){
                System.out.println("Ladder found at position " + currentPlayer.getPosition());
                currentPlayer.setPosition(currentCell.getLadder().getEnd());
                System.out.println("After ladder position is " + currentPlayer.getPosition());
            }else if(currentCell.getSnake() != null){
                System.out.println("Snake found at position " + currentPlayer.getPosition());
                currentPlayer.setPosition(currentCell.getSnake().getEnd());
                System.out.println("After snake position is " + currentPlayer.getPosition());
            }
        }else if(currentPlayer.getPosition()+value == 99){
            this.winner = currentPlayer;
            this.gameState = GameState.ENDED;
        }else{
            System.out.println(currentPlayer.getName()+" made invalide move of "+ value+" his current position is still : "+currentPlayer.getPosition());
        }
        return gameState;
    }

    public Player getWinner(){
        return this.winner;
    }

    public GameState getGameState(){
        return this.gameState;
    }
}
