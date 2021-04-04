public class Sudoku {
  /*
   public static int[][] GRID_TO_SOLVE = {
            { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
            { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
            { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
            { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
            { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
            { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
            { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
            { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
            { 7, 0, 3, 0, 1, 8, 0, 0, 0 },
    };*/

    private int[][] board;

    public Sudoku(int[][] board) {
        this.board = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                this.board[row][column] = board[row][column];
            }
        }
    }

    public boolean isNumberInRow(int number, int row) {
        for (int column = 0; column < 9; column++) {
            if (board[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInColumn(int number, int column) {
        for (int row = 0; row < 9; row++) {
            if (board[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInSubgrid(int number, int row, int column) {
        int rsubgrid = row - row % 3;
        int csubgrid = column - column % 3;

        for (int x = rsubgrid; x < rsubgrid + 3; x++) {
            for (int y = csubgrid; y < csubgrid + 3; y++) {
                if (board[x][y] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isPossibleNumber(int number, int row, int column) {
        if (!isNumberInRow(number, row) && !isNumberInColumn(number, column) && !isNumberInSubgrid(number, row, column)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isPossibleNumber(number, row, column)) {
                            board[row][column] = number;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true; // sudoku solved
    }

    public void display() {
        int row = 0;
        int column = 0;
        for ( row = 0; row < 9; row++) {
            for ( column = 0; column < 9; column++) {
                System.out.print(" " + board[row][column]);
            }
            System.out.println();
        }
         System.out.println();
    }

    /*
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
        System.out.println("Sudoku grid to solve");
        sudoku.display();

        if (sudoku.solve()) {
            System.out.println("Sudoku Grid solved...");
            sudoku.display();
        } else {
            System.out.println("Unsolvable");
        }
    }*/

}
