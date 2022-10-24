package minesweeper;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public static int rows = Game.gridSize;
    public static int cols = Game.gridSize;
    public static Cell[][] board = new Cell[rows][cols];

    private int openedCells = 0;

    public Board (GridLayout gridLayout, Handler handler) {
        super(gridLayout);
        initializeBoard(handler);
        createMines();
        addProximity();
        createGrid();
        handler.setBoard(this);
    }

    public void initializeBoard(Handler handler) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new Cell(0, row, col,false, false, handler);
            }
        }
    }

    public void createMines() {
        int row, col;
        for (int i = 0; i < Game.minesAmount;) {
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
            if (board[row][col].getType() == 0) {
                board[row][col].setType(1);
                ++i;
            }
        }
    }

    public void addProximity() {
        int counter;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                counter = 0;
                if (board[row][col].getType() != 1) {
                    if (validCell(row-1, col-1) && board[row-1][col-1].getType() == 1) {
                        counter++;
                    } if (validCell(row-1, col) && board[row-1][col].getType() == 1) {
                        counter++;
                    } if (validCell(row-1, col+1) && board[row-1][col+1].getType() == 1) {
                        counter++;
                    } if (validCell(row, col-1) && board[row][col-1].getType() == 1) {
                        counter++;
                    } if (validCell(row, col+1) && board[row][col+1].getType() == 1) {
                        counter++;
                    } if (validCell(row+1, col-1) && board[row+1][col-1].getType() == 1) {
                        counter++;
                    } if (validCell(row+1, col) && board[row+1][col].getType() == 1) {
                        counter++;
                    } if (validCell(row+1, col+1) && board[row+1][col+1].getType() == 1) {
                        counter++;
                    }
                }
                if (counter != 0) {
                    board[row][col].setType(2);
                    board[row][col].setCount(counter);
                    //TODO use counter
                }
            }
        }
    }

    public void createGrid() {
        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.add(board[i][j]);
            }
        }
    }

    public boolean validCell(int row, int col) { //TODO consider lambda
        return (row >= 0 && row < rows) && (col >= 0 && col < cols);
    }

    public void openCell(int row, int col) {
        board[row][col].setOpened();
        board[row][col].setEnabled(false); //TODO check
        if (board[row][col].getType() == 1) {
            board[row][col].setText("X");
        } else if (board[row][col].getType() == 2) {
            board[row][col].setText(String.valueOf(board[row][col].getCount()));
        }
        setOpenedCells(getOpenedCells() + 1);
    }

    public void openBoard(int row, int col) {
        if (row < 0) return;
        if (row > rows-1) return;
        if (col < 0) return;
        if (col > cols-1) return;

        if (!board[row][col].isOpened() && board[row][col].getType() == 0) {
            openCell(row, col);
            openBoard(row-1, col-1);
            openBoard(row-1, col+1);
            openBoard(row+1, col-1);
            openBoard(row+1, col+1);
            openBoard(row-1, col);
            openBoard(row+1, col);
            openBoard(row, col-1);
            openBoard(row, col+1);
        } else if (!board[row][col].isOpened()) { //TODO check if the type is 1??
            openCell(row, col);
        }
    }

    public void openBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                openCell(row, col);
            }
        }
    }

    public int getOpenedCells() {
        return openedCells;
    }

    public void setOpenedCells(int openedCells) {
        this.openedCells = openedCells;
    }
}
