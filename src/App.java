import java.awt.*;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;


// This ENTIRE class is to be rewritten with proper inheritance
// Will extend a either JPanel or Canvas in order to fix rendering issues

// OHHHHHHH the window is a frame, but drawing directly to that frame is stupid so you draw onto a canvas that is placed on the frame

public class App extends Canvas {
    private final EventManager eventManager = new EventManager();

    // Setup the screen
    public App() {
        setVisible(true);
        setIgnoreRepaint(true);
        setSize(500, 600);
        addWindowListener(eventManager);
    }

    // 0 to upperBound(exlcusive)
    public static double randRange(int lowerBound, int upperBound) {
        return lowerBound + Math.random() * (upperBound - lowerBound);
    }

    // Initially create the particles
    public static Particle[] createParticles(int size) {
        Particle[] arr = new Particle[size];

        for (int i = 0; i < size; i++) {
            Vec2d initialPos = new Vec2d(randRange(50, 450), randRange(100, 500));
            Vec2d initialVel = new Vec2d(1, 1);
            int radius = 10;
            arr[i] = new Particle(initialPos, initialVel, radius);
        }

        return arr;
    }

    @Override
    public void paint(Graphics g) {}

    // Main
    public static void main(String[] args) throws Exception {

        // Setup the application
        App frame = new App();
        Canvas myCanvas = new Canvas();
        Graphics2D graphics = (Graphics2D) myCanvas.getGraphics();
        graphics.setBackground(Color.BLACK); // Set the background to black

        add(myCanvas);

        // The particles
        Particle[] particles = createParticles(10);

        // Deltatime
        long prevTime = System.nanoTime();
        long currentTime = prevTime;
        long deltaTime;

        // Main game loop
        graphics.setColor(Color.RED);
        while (true) {
            // Update Delta Time
            prevTime = currentTime;
            currentTime = System.nanoTime();
            deltaTime = currentTime - prevTime;
            if (deltaTime == 0) {
                System.err.println("No time elapsed?");
            }

            // Clear the screen
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, 500, 600);
            // graphics.clearRect(0, 0, 500, 600);

            // Draw every particle
            graphics.setColor(Color.RED);
            for (Particle particle : particles) {
                // Get the rounded x and y coords
                int x = (int) Math.round(particle.getPosX());
                int y = (int) Math.round(particle.getPosY());

                // Draw an oval at each one
                graphics.fillOval(x, y, particle.radius, particle.radius);


                // Update the particles
                // particle.update(deltaTime);
            }
        }
    }
}
