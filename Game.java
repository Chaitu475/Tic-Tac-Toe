import java.util.*;
public class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayer;

    public Game(int size, Player p1, Player p2) {
        this.board = new Board(size);
        this.players = new Player[]{p1, p2};
        this.currentPlayer = new Random().nextInt(2);
    }

    public void start() {
        while (true) {
            board.printBoard();
            Player player = players[currentPlayer];
            System.out.println("Player " + player.getSymbol() + "'s turn.");
            int[] move = player.makeMove(board);
            if (move == null || !board.placeSymbol(move[0], move[1], player.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (board.checkWin(player.getSymbol())) {
                board.printBoard();
                System.out.println("Player " + player.getSymbol() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Game is a draw.");
                break;
            }

            currentPlayer = 1 - currentPlayer;
        }
    }
}
