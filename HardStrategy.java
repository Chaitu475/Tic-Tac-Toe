import java.util.List;
import java.util.Random;

public class HardStrategy implements BotStrategy {
    public int[] decideMove(Board board, Symbol symbol) {
        List<int[]> available = board.getAvailableCells();
        if (available.isEmpty()) return null;
        return available.get(new Random().nextInt(available.size()));
    }
}
