package minesweeper;

public class Handler {

    private Board board;  //TODO better way to use DI

    public void click (Cell cell) {
        int row = cell.getPos_x(), col = cell.getPos_y();
        System.out.println("Your click is X: " + row + " Y: " + col);
        if (cell.getType() == 1) {
            openCell(row, col);
            board.openBoard();
            System.out.println("Your game is over!");
        } else if (cell.getType() == 2) {
            openCell(row, col);
        } else {
            openCells(row, col);
        }
        checkWin();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void openCells (int row, int col) {
        board.openBoard(row, col);
    }

    public void openCell (int row, int col) {
        board.openCell(row, col);
    }

    public boolean checkWin() {
        if (board.getOpenedCells() - Game.minesAmount == 0) {
            System.out.println("You won!");
            board.openBoard(); //TODO replace ??
            return true;
        }
        return false;
    }
}
