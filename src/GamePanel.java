import java.awt.*;

// Essentially a game managing class
public class GamePanel extends Canvas {
    private final Particle centerParticle;

    // Constructor, setting things like the background
    public GamePanel() {
        setBackground(Color.BLACK);

        Vec2d centerPos = new Vec2d(200, 200);
        Vec2d vel = new Vec2d(0, 0);

        centerParticle = new Particle(centerPos, vel, 100);
    }


    // Painting function
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        int x = (int) centerParticle.getPosX();
        int y = (int) centerParticle.getPosY();
        int r = (int) centerParticle.getRadius();
        g2d.fillOval(x, y, r, r);
    }


    // A function to recall the paint function
    public void updateGame() {
        repaint();
    }
    
}
