public class Particle {
    private Vec2d pos;
    private Vec2d vel;
    private int radius;
    private final int mass;
    private final double GRAVITATIONAL_CONSTANT = 0.000000000066743;


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

    // Update the position by adding the velocity and enforcing bounds. Bounds shouldn't be managed by this class but
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


    // Gravity system between two particles
    public void gravity(Particle otherParticle) {
        // F_g = G*((M1 * M2) / R^2)

        Vec2d directionalVec = this.pos.sub(otherParticle.getPos());
        double distance = directionalVec.magnitude();
        double gravityPull = GRAVITATIONAL_CONSTANT * (otherParticle.getMass() * this.getMass()) / (distance * distance);

        Vec2d normalizedDirectionalVec = directionalVec.normalize();

        // New velocity
        this.vel = this.vel.add(normalizedDirectionalVec.multiply(gravityPull));
    }




    // Getters
    // Get xy Pos
    public Vec2d getPos() {
        return this.pos;
    }

    public Vec2d getVel() {
        return this.vel;
    }
    
    public double getPosX() {
        return this.pos.x;
    }

    public double getPosY() {
        return this.pos.y;
    }

    public double getVelX() {
        return this.vel.x;
    }

    public double getVelY() {
        return this.vel.y;
    }

    // Get radius and mass
    public int getRadius() {
        return this.radius;
    }

    public int getMass() {
        return this.mass;
    }


    // Setters
    public void setPosX(double xPos) {
        this.pos.x = xPos;
    }



}
