package minesweeper;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JButton {

    private int type; // 0-empty 1-mine 2-number
    private int pos_x;
    private int pos_y;
    private boolean opened;
    private boolean flagged;

    private int count;

    private Handler handler;

    public Cell(int type, int pos_x, int pos_y, boolean opened, boolean flagged, Handler handler) {
        this.type = type;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.opened = opened;
        this.flagged = flagged;
        this.handler = handler;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickButton();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened() {
        this.opened = true;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void clickButton() {
        handler.click(this);
    }
}
