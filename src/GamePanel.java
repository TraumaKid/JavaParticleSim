import java.awt.*;

// Essentially a game managing class
public class GamePanel extends Canvas {
    private final Particle centerParticle;
    private Particle[] particles;

    // Constructor, setting things like the background and center particle and particles
    public GamePanel() {
        setBackground(Color.BLACK);

        Vec2d centerPos = new Vec2d(Constants.WIDTH / 2, Constants.HEIGHT / 2);
        Vec2d vel = new Vec2d(0, 0);

        centerParticle = new Particle(centerPos, vel, 20, 1000);

        int numOfParticles = 2000;
        initParticles(numOfParticles);
    }


    // Init all the particles
    public final void initParticles(int length) {
        particles = new Particle[length];

        for (int i = 0; i<length; i++) {
            // Create a particle at a random location, first setting all the initial locations
            int x = MathFuncs.randomInt(50);
            int y = MathFuncs.randomInt(25, 100);
            Vec2d pos = new Vec2d(x, y);

            // Set the initial speed
            Vec2d vel = new Vec2d(MathFuncs.randomInt(1, 10), 0);

            // Set the initial radius
            int radius = 2;

            // Add the new particle to the particles array
            Particle newParticle = new Particle(pos, vel, radius, 5);
            particles[i] = newParticle;
            
        }

    }


    // A function defined to draw a particle passed onto the graphics passed
    public void drawParticle(Particle particle, Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        int x = (int) particle.getPosX();
        int y = (int) particle.getPosY();
        int r = (int) particle.getRadius();
        g2d.fillOval(x, y, r, r);

    }


    // Painting function
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawParticle(centerParticle, g2d);

        // Draw the smaller particles and update them
        for (Particle particle : particles) {
            Vec2d pos = particle.getPos();

            // Only draw particles on screen
            if ((pos.x > -10 && pos.x < Constants.WIDTH + 10) && (pos.y > -10 && pos.y < Constants.HEIGHT + 10)) {
                drawParticle(particle, g2d);
            }


            // Update the particle
            particle.update();

            // Apply gravity to the particle
            particle.gravity(centerParticle);

        }
    }


    // A function to recall the paint function and update all the particles which is handled in the paint function to avoid having multiple loops
    public void updateGame() {
        repaint();


        // Uncomment for interactions between particles
        // for (int i = 0; i<particles.length; i++) {
        //     Particle firstParticle = particles[i];
            
        //     for (int j = 0; j<particles.length; j++) {
        //         Particle secondParticle = particles[j];

        //         if (firstParticle != secondParticle && Particle.distance(firstParticle, secondParticle) < 75.D) {
        //             firstParticle.gravity(secondParticle);
        //         }
        //     }

        //     firstParticle.gravity(centerParticle);
        // }
    }
    
}
