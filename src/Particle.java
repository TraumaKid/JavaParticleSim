public class Particle {
    private Vec2d pos;
    private Vec2d vel;
    public int radius;
    public int mass;

    public Particle(Vec2d initialPos, Vec2d initialVel, int radiusI) {
        pos = initialPos;
        vel = initialVel;
        radius = radiusI;
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



}
