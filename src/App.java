import java.awt.*;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;



// Canvas is half working. Needs to be into fullscreen to start to work.


public class App extends Frame {
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


        // Set screen to visible
    }


    /*
     * To Be Moved
     * Most likely a seperate file
     */
    // // 0 to upperBound(exlcusive)
    // public static double randRange(int lowerBound, int upperBound) {
    //     return lowerBound + Math.random() * (upperBound - lowerBound);
    // }

    // // Initially create the particles
    // public static Particle[] createParticles(int size) {
    //     Particle[] arr = new Particle[size];

    //     for (int i = 0; i < size; i++) {
    //         Vec2d initialPos = new Vec2d(randRange(50, 450), randRange(100, 500));
    //         Vec2d initialVel = new Vec2d(1, 1);
    //         int radius = 10;
    //         arr[i] = new Particle(initialPos, initialVel, radius);
    //     }

    //     return arr;
    // }


    // Empty override 
    @Override
    public void paint(Graphics g) {

    }


    // Main game loop functions

    public void startGame() {
        // Use a timer
        isRunning = true;
        gameThread = new Thread(syncrhronized() -> {
            while (isRunning) {
                System.out.println("Help");
                game.updateGame();
                try {
                    gameThread.wait(16);
                } catch (InterruptedException ex) {
                    System.err.println("Failed:\n" + ex.getMessage());
                    System.exit(-1);
                }
            }
        });
        
        gameThread.start();
    }

    public void endGame() {
        isRunning = false;
        try {
            gameThread.join();
        } catch (InterruptedException ex) {
            System.err.println("Couldn't close thread?");
        }

    }


    public static void main(String[] args) throws Exception {

        // Setup the application
        App app = new App();
        app.startGame();
        // app.endGame();
        
    }
}
