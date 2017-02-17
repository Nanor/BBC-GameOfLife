package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void testParsing() {
        String input = ".*.\n*.*\n...";
        GameState testState = new GameStateImpl(input);
        assertTrue("Row 0, col 1 should be alive", testState.isCellAliveAt(0, 1));
        assertFalse("Row 2, col 2 should not be alive", testState.isCellAliveAt(2, 2));
        assertFalse("Row -1, col 1 should not be alive", testState.isCellAliveAt(-1, 1));
        assertFalse("Row 3, col 1 should not be alive", testState.isCellAliveAt(3, 1));
    }

    @Test
    public void testRowColCounts() {
        String input = "...\n***";
        GameState testState = new GameStateImpl(input);
        assertEquals("The game should have 3 columns", 3, testState.getCols());
        assertEquals("The game should have 3 rows", 2, testState.getRows());
    }

    @Test
    public void testJaggedParing() {
        String input = "*\n.*\n..*\n.*\n*";
        GameState testState = new GameStateImpl(input);
        assertEquals("It should make a square game", "*..\n.*.\n..*\n.*.\n*..", testState.toString());
    }

    @Test
    public void testToString() {
        String input = ".*.\n*.*\n...";
        GameState testState = new GameStateImpl(input);
        assertEquals("toString should return the same as the input string", input, testState.toString());
    }
}
