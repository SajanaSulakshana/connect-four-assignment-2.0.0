package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;


    public BoardImpl(BoardUI boardUI) {
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        this.boardUI = boardUI;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {

            for (int j = 0; j < 5 ; j++) {
                if (pieces[col][j].equals(Piece.EMPTY)) {
                        return j;
                }

        };
            return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if ( findNextAvailableSpot(col)==-1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean exitLegalMoves() {
        for (int i = 0; i < 6; i++) {

            if (findNextAvailableSpot(i) == -1) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void updateMove(int col, Piece move) {

        pieces[col][findNextAvailableSpot(col)]=move;
    }

    @Override
    public Winner findWinner() {
        return null;
    }
}
