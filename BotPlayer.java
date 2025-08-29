public class BotPlayer extends Player {
    private BotStrategy strategy;

    public BotPlayer(Symbol symbol, BotStrategy strategy) {
        super(symbol);
        this.strategy = strategy;
    }

    @Override
    public int[] makeMove(Board board) {
        return strategy.decideMove(board, symbol);
    }
}
