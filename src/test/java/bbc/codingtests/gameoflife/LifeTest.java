package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(ZohhakRunner.class)
public class LifeTest {

    @TestWith({
            "An empty grid should stay the same,            ...\n...\n..., ...\n...\n...",
            "A single cell should die,                      ...\n.*.\n..., ...\n...\n...",
            "Overpopulated cells should die,                ***\n***\n***, *.*\n...\n*.*",
            "Cells should survive with 3 neighbors,         **.\n**.\n..., **.\n**.\n...",
            "Cells should generate with 3 neighbours,       **.\n*..\n..., **.\n**.\n...",
            "A horizontal line should evolve as expected,   ...\n***\n..., .*.\n.*.\n.*.",
            "A vertical line should evolve as expected,     .*.\n.*.\n.*., ...\n***\n..."
    })
    public void testSingleEvolution(String message, String input, String output) {
        Life testLife = new LifeImpl();
        GameState gameState = new GameStateImpl(input);
        assertEquals(message, output, testLife.evolve(gameState).toString());
    }
}
