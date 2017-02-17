package bbc.codingtests.gameoflife.gamestate;

import java.util.Arrays;

public class GameStateImpl implements GameState {

    private boolean[][] state;

    @Override
    public String toString() {
        String output = "";
        for (int row = 0; row < this.getRows(); row++) {
            for (int col = 0; col < this.getCols(); col++) {
                output += this.isCellAliveAt(row, col) ? '*' : '.';
            }
            if (row < this.getRows() - 1) {
                output += '\n';
            }
        }
        return output;
    }

    public GameStateImpl(String input) {
        int rows = input.split("\n").length;
        int cols = Arrays.stream(input.split("\n")).map(String::length).max(Integer::compareTo).orElse(0);

        this.state = new boolean[rows][cols];

        int row = 0;
        int col = 0;
        for (Character c : input.toCharArray()) {
            switch (c) {
                case '.':
                    this.state[row][col] = false;
                    col++;
                    break;
                case '*':
                    this.state[row][col] = true;
                    col++;
                    break;
                case '\n':
                    col = 0;
                    row++;
                    break;
                default:
                    throw new InvalidGameStateException(String.format("%s is not a valid game character", c));
            }
        }
    }

    public boolean isCellAliveAt(int row, int col) {
        return row >= 0 && row < this.getRows() && col >= 0 && col < this.getCols() && state[row][col];
    }

    public int getRows() {
        return this.state.length;
    }

    public int getCols() {
        return this.state[0].length;
    }
}
