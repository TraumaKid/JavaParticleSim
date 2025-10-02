import java.awt.*;
import java.awt.event.*;



public class App extends Frame implements KeyListener {
    private final EventManager eventManager = new EventManager();
    private final GamePanel game = new GamePanel();
    private Thread gameThread;
    private boolean isRunning;

    // Setup the screen
    public App() {
        // Initialize everything
        setIgnoreRepaint(true);
        setSize(500, 600);
        // setResizable(false);

        // The place where all the drawing is happening. On a canvas which is created and added to the main
        add(game);
        setVisible(true);

        // Mangage window events
        addWindowListener(eventManager);
        addKeyListener(this);
    }


    // Empty override of paint
    @Override
    public void paint(Graphics g) {

    }


    // Key events
    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'q') {
            this.endGame();
        }
    }



    // Main game loop functions

    // Hosts the main game loop
    public void startGame() {
        // Use a timer
        isRunning = true;
        gameThread = new Thread(() -> {
            while (isRunning) {
                // Update the game every frame
                game.updateGame();

                // Attempt to sleep for 16 ms resulting in roughly 60 fps
                try {
                    Thread.sleep(16);
                } catch (InterruptedException ex) {
                    System.err.println("Failed:\n" + ex.getMessage());
                    System.exit(-1);
                }
            }
        });
        
        gameThread.start();
    }

    // End the game by stopping the other thread
    public void endGame() {
        isRunning = false;
        try {
            // Join the game thread to the main one and then end the process
            gameThread.join();
            System.exit(0);
        } catch (InterruptedException ex) {
            System.err.println("Couldn't close thread?");
        }

    }


    public static void main(String[] args) throws Exception {

        // Setup the application and run it
        App app = new App();
        app.startGame();
        
    }
}
