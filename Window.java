package minesweeper;

import javax.swing.*;
import java.awt.*;

public class Window {

    public static JFrame frame;
    private static String title;

    public Window(int width, int height, int gridSize, String title, Game game, Handler handler) {
        Window.setTitle(title);
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel jPanel = new Board(new GridLayout(gridSize, gridSize), handler);

        frame.setContentPane(jPanel);
        frame.pack();

        frame.setVisible(true);
//        frame.setLayout(new BorderLayout());
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Window.title = title;
    }
}
