import java.util.*;

public class EasyStrategy implements BotStrategy {
    public int[] decideMove(Board board, Symbol symbol) {
        List<int[]> available = board.getAvailableCells();
        if (available.isEmpty()) return null;
        return available.get(new Random().nextInt(available.size()));
    }
}
