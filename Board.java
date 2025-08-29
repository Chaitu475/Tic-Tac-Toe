import java.util.*;

public class Board {
    private final int size;
    private Symbol[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) {
        if (isValidMove(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return 0 <= row && row < size && 0 <= col && col < size && grid[row][col] == null;
    }

    public boolean isFull() {
        for (Symbol[] row : grid)
            for (Symbol cell : row)
                if (cell == null) return false;
        return true;
    }

    public List<int[]> getAvailableCells() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == null)
                    list.add(new int[]{i, j});
        return list;
    }

    public boolean checkWin(Symbol symbol) {

        for (int i = 0; i < size; i++) {
            if (checkLine(symbol, i, 0, 0, 1) || checkLine(symbol, 0, i, 1, 0)) return true;
        }

        return checkLine(symbol, 0, 0, 1, 1) || checkLine(symbol, 0, size - 1, 1, -1);
    }

    private boolean checkLine(Symbol symbol, int startRow, int startCol, int dx, int dy) {
        for (int i = 0; i < size; i++) {
            int r = startRow + i * dx;
            int c = startCol + i * dy;
            if (grid[r][c] != symbol) return false;
        }
        return true;
    }

    public void printBoard() {
        for (Symbol[] row : grid) {
            for (Symbol cell : row)
                System.out.print((cell == null ? "-" : cell) + " ");
            System.out.println();
        }
    }
}
