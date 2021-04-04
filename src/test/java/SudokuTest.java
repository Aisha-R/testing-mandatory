import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    private Sudoku underTest;
    private int[][] problem;

    @BeforeEach
    void setUp() {
        problem = new int[][] {
                { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
                { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
                { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
                { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
                { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
                { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
                { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
                { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
                { 7, 0, 3, 0, 1, 8, 0, 0, 0 },
        };
        underTest = new Sudoku(problem);
    }

    @Test
    void shouldCheckIfNumberIsInRow() {
        //given
        int number = 6;
        int row = 0;

        //when
        boolean result = underTest.isNumberInRow(number, row);

        //then
        assertTrue(result);
    }

    @Test
    void shouldCheckIfNumberIsNotInRow() {
        //given
        int number = 9;
        int row = 5;

        //when
        boolean result = underTest.isNumberInRow(number, row);

        //then
        assertFalse(result);
    }

    @Test
    void shouldCheckIfNumberIsInColumn() {
        //given
        int number = 3;
        int column = 7;

        //when
        boolean result = underTest.isNumberInColumn(number, column);

        //then
        assertTrue(result);
    }

    @Test
    void shouldCheckIfNumberIsNotInColumn() {
        //given
        int number = 1;
        int column = 2;

        //when
        boolean result = underTest.isNumberInColumn(number, column);

        //then
        assertFalse(result);
    }

    @Test
    void shouldCheckIfNumberIsInSubgrid() {
        //given
        int number = 5;
        int row = 8;
        int column = 4;

        //when
        boolean result = underTest.isNumberInSubgrid(number, row, column);

        //then
        assertTrue(result);
    }

    @Test
    void shouldCheckIfNumberIsNotInSubgrid() {
        //given
        int number = 9;
        int row = 5;
        int column = 1;

        //when
        boolean result = underTest.isNumberInSubgrid(number, row, column);

        //then
        assertFalse(result);
    }

    @Test
    void shouldBePossible() {
        //given
        int number = 8;
        int row = 0;
        int column = 7;

        //when
        boolean result = underTest.isPossibleNumber(number, row, column);

        //then
        assertTrue(result);
    }

    @Test
    void shouldNotBePossible() {
        //given
        int number = 9;
        int row = 6;
        int column = 0;

        //when
        boolean result = underTest.isPossibleNumber(number, row, column);

        //then
        assertFalse(result);
    }

    @Test
    void shouldSolveProblem() {
        //when
        boolean result = underTest.solve();

        //then
        assertTrue(result);
    }

    @Test
    void shouldDisplayBoard() {
        //when
        String result = underTest.toString();

        //then
        assertEquals(String.valueOf(underTest), result);

    }

}