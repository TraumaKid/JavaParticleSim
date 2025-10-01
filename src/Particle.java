public class Particle {
    private Vec2d pos;
    private Vec2d vel;
    private int radius;
    private int mass;


    // Constructors
    public Particle(Vec2d aInitialPos, Vec2d aInitialVel, int aRadius) {
        pos = aInitialPos;
        vel = aInitialVel;
        radius = aRadius;
        mass = 100;
    }

    public Particle(Vec2d aInitialPos, Vec2d aInitialVel, int aRadius, int aMass) {
        pos = aInitialPos;
        vel = aInitialVel;
        radius = aRadius;
        mass = aMass;
    }

    // Update the position by adding the velocity and enforcing bounds
    public void update(long deltaTime) {
        Vec2d changeInVel = vel.multiply(deltaTime / 1_000_000D);
        // System.out.println(changeInVel);
        pos = pos.add(changeInVel);
        

        if (pos.x > 510) {
            pos.x = -10;
            System.out.println("Ran");
        }
        if (pos.y > 610) {
            pos.y = -10;
            System.out.println("Run");

        }
    }


    // Getters
    // Get xy Pos
    public double getPosX() {
        return pos.x;
    }

    public double getPosY() {
        return pos.y;
    }

    public double getVelX() {
        return vel.x;
    }

    public double getVelY() {
        return vel.y;
    }

    // Get radius and mass
    public int getRadius() {
        return radius;
    }

    public int getMass() {
        return mass;
    }



}
