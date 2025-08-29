//HI
public class Main {
    public static void main(String[] args) {
        int size = 3;
        Player p1 = PlayerFactory.createHumanPlayer(Symbol.X, "Alice", "alice@example.com", "img.png");
        Player p2 = PlayerFactory.createBotPlayer(Symbol.O, Difficultylevel.EASY);
        Game game = new Game(size, p1, p2);
        game.start();
    }
}
