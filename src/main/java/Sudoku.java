public class Sudoku {

    private int[][] board;

    public Sudoku(int[][] board) {
        this.board = new int[9][9];

        for ( int row = 0 ; row < 9 ; row++ ) {
            for ( int column = 0 ; column < 9 ; column++ ) {
                this.board[row][column] = board[row][column];
            }
        }
    }

    public boolean isNumberInRow(int number, int row) {
        for ( int column = 0 ; column < 9 ; column++ ) {
            if ( board[row][column] == number ) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInColumn(int number, int column) {
        for ( int row = 0 ; row < 9 ; row++ ) {
            if ( board[row][column] == number ) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInSubgrid(int number, int row, int column) {
        int rsubgrid = row - row % 3;
        int csubgrid = column - column % 3;

        for ( int x = rsubgrid ; x < rsubgrid + 3 ; x++) {
            for ( int y = csubgrid ; y < csubgrid + 3 ; y++) {
                if ( board[x][y] == number ) {
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

}
