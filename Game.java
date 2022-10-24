package minesweeper;


public class Game {

    public static final int width = 480;
    public static final int height = 480;
    public static final int gridSize = 10;
    public static final int minesAmount = 10;

    Window window; //TODO something about it

    private Handler handler = new Handler();

    public Game () {
        new Window(width, height, gridSize, "Minesweeper", this, handler);
    }
}

