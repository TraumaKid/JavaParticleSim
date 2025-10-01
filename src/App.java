import java.awt.*;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;



// Canvas is half working. Needs to be into fullscreen to start to work.


public class App extends Frame {
    private final EventManager eventManager = new EventManager();
    private Thread gameThread;
    private boolean isRunning;

    // Setup the screen
    public App() {
        setVisible(true);
        setIgnoreRepaint(true);
        setSize(500, 600);
        // setResizable(false);
        addWindowListener(eventManager);

        // The place where all the drawing is happening
        GamePanel game = new GamePanel();
        add(game);
        game.paint(getGraphics());
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
        

    }

    public void endGame() {

    }


    public static void main(String[] args) throws Exception {

        // Setup the application
        App frame = new App();
        // frame.startGame();
        
    }
}
