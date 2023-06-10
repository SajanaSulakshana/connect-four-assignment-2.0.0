package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player{
    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        Random r= new Random();
        do {
            col=r.nextInt(6);
        }while (!board.isLegalMove(col));
        if (board.isLegalMove(col)) {
            board.updateMove(col,Piece.GREEN);
            board.getBoardUI().update(col,false);
        }
    }
}
