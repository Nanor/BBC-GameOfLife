package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life {
    public GameState evolve(GameState currentState) {
        String nextState = "";

        for (int x = 0; x < currentState.getRows(); x++) {
            for (int y = 0; y < currentState.getCols(); y++) {
                int neighbourCount = getNeighbourCount(currentState, x, y);

                switch (neighbourCount) {
                    case 2:
                        // Cells with 2 neighbours stay alive if they were alive and stay dead if they were not
                        nextState += currentState.isCellAliveAt(x, y) ? '*' : '.';
                        break;
                    case 3:
                        // Cells with 3 neighbours become alive if they were not alive and stay alive if they were
                        nextState += '*';
                        break;
                    default:
                        // Cells with less than 2 neighbours or more than 3 die if they were alive and stay dead otherwise
                        nextState += '.';
                        break;
                }
            }
            if (x <= currentState.getRows()) {
                nextState += '\n';
            }
        }

        return new GameStateImpl(nextState);
    }

    /**
     * @param state The GameState object to check
     * @param row   The cell row to check
     * @param col   The cell column to check
     * @return The number of neighbours the checked cell has. Diagonals are included.
     */
    private int getNeighbourCount(GameState state, int row, int col) {
        int total = 0;
        for (int x = row - 1; x <= row + 1; x++) {
            for (int y = col - 1; y <= col + 1; y++) {
                // Don't count the cell itself in the neighbour count
                if (x == row && y == col) {
                    continue;
                }
                if (state.isCellAliveAt(x, y)) {
                    total++;
                }
            }
        }
        return total;
    }
}
