package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState {

    private boolean[][] state;

    @Override
    public String toString() {
        String output = "";
        for (int x = 0; x < this.getRows(); x++) {
            for (int y = 0; y < this.getCols(); y++) {
                output += this.isCellAliveAt(x, y) ? '*' : '.';
            }
            if (x < this.getCols() -1) {
                output += '\n';
            }
        }
        return output;
    }

    public GameStateImpl(String input) {
        int rows = input.split("\n").length;
        int cols = input.split("\n")[0].length();

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
                    throw new InvalidGameStateException(c + " is not a valid game character");
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
