package bbc.codingtests.gameoflife.gamestate;

class InvalidGameStateException extends RuntimeException {
    InvalidGameStateException(String s) {
        super(s);
    }
}
